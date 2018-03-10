package by.fyodorov.servletproject.connector;

import by.fyodorov.servletproject.entity.AbstractPlantEntity;
import by.fyodorov.servletproject.exception.XmlException;
import by.fyodorov.servletproject.parser.DomXmlParser;
import by.fyodorov.servletproject.parser.SaxXmlParser;
import by.fyodorov.servletproject.parser.StaxXmlParser;
import by.fyodorov.servletproject.parser.XmlParser;
import by.fyodorov.servletproject.validator.XmlSchemaValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

/**
 * class for handling Http requests
 */
public class MainServlet extends HttpServlet {
    private final Logger LOGGER = LogManager.getLogger(MainServlet.class);
    private static final String PARSER_KEY = "parser";

    private static final String DOM_PARSER = "DOM";
    private static final String SAX_PARSER = "SAX";
    private static final String StAX_PARSER = "StAX";

    private static final String FILE_KEY = "file";
    private static final String RESULT_KEY = "result";
    private static final String VALIDATE_KEY = "validate";
    private static final String NEXT_PAGE_PATH = "/pages/result.jsp";
    private static final String XSD_PATH = "/xml/flowersValidation.xsd";
    private static final String CLONE_XML = "/xml/clone.xml";

    /**
     * doGet method for REST interface
     * @param req - request from browser
     * @param resp - response from server to browser
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        LOGGER.info("GET method");
        processRequest(req, resp);
    }

    /**
     * doPost method for REST interface
     * @param req - request from browser
     * @param resp - response from server to browser
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        LOGGER.info("POST method");
        processRequest(req, resp);
    }

    /**
     * processing action by using request and response from browser
     * @param request - request from browser
     * @param response - response from server
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            Part filePart = request.getPart(FILE_KEY);
            Path path = Paths.get(filePart.getSubmittedFileName());
            InputStream inputStream = filePart.getInputStream();
            FileWriter writer = new FileWriter(getServletContext().getRealPath(CLONE_XML));
            while (inputStream.available() > 0) {
                writer.write(inputStream.read());
            }
            writer.flush();
            writer.close();

            LOGGER.info("input = \"" + path.toAbsolutePath() + "\"");
            String uploadFileName = path.getFileName().toString();
            LOGGER.info("getting file = \"" + uploadFileName + "\"");

            XmlSchemaValidator validator = new XmlSchemaValidator();
            request.setAttribute(VALIDATE_KEY, validator.validate(getServletContext().getRealPath(XSD_PATH), getServletContext().getRealPath(CLONE_XML)));
            XmlParser parser = getParser(request.getParameter(PARSER_KEY));
            LinkedList<AbstractPlantEntity> list = parser.parseFile(getServletContext().getRealPath(CLONE_XML));
            StringBuilder builder = new StringBuilder();
            for (AbstractPlantEntity entity : list) {
                builder.append(entity.toHtml());
            }
            request.setAttribute(RESULT_KEY, builder.toString());
            request.getRequestDispatcher(NEXT_PAGE_PATH).forward(request, response);
        } catch (IOException | ServletException | XmlException e) {
            LOGGER.catching(e);
        }
    }

    /**
     * getting parser by name of parser
     * @param quote - name of parser
     * @return - object of chosen parser
     */
    private XmlParser getParser(String quote) {
        switch (quote) {
            case DOM_PARSER: {
                return new DomXmlParser();
            }
            case SAX_PARSER: {
                return new SaxXmlParser();
            }
            case StAX_PARSER: {
                return new StaxXmlParser();
            }
            default: {
                return new DomXmlParser();
            }
        }
    }
}
