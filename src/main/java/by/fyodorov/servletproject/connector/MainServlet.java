package by.fyodorov.servletproject.connector;

import by.fyodorov.servletproject.entity.AbstractPlantEntity;
import by.fyodorov.servletproject.exception.XmlException;
import by.fyodorov.servletproject.parser.DomXmlParser;
import by.fyodorov.servletproject.parser.XmlParser;
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

public class MainServlet extends HttpServlet {

    private final Logger LOGGER = LogManager.getLogger(MainServlet.class);

    public MainServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("GET method");
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("POST method");
        processRequest(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.catching(e);
        }

        Part filePart = null;
        try {
            filePart = request.getPart("file");
            Path path = Paths.get(filePart.getSubmittedFileName());
            InputStream inputStream = filePart.getInputStream();
            FileWriter writer = new FileWriter(path.toAbsolutePath().toFile());
            while (inputStream.available() > 0) {
                writer.write(inputStream.read());
            }
            writer.flush();
            writer.close();

            LOGGER.info("input = \"" + path.toAbsolutePath() + "\"");
            String uploadFileName = path.getFileName().toString();
            LOGGER.info("getting file = \"" + uploadFileName + "\"");

            XmlParser parser = new DomXmlParser();
            LinkedList<AbstractPlantEntity> list = parser.parseFile(path.toAbsolutePath().toString());
            StringBuilder builder = new StringBuilder();
            for (AbstractPlantEntity entity : list) {
                builder.append(entity.toHtml());
            }
            request.setAttribute("res", builder.toString());
            request.getRequestDispatcher("/pages/result.jsp").forward(request, response);
        } catch (IOException | ServletException | XmlException e) {
            LOGGER.catching(e);
        }
    }
}
