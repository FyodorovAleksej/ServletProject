package by.fyodorov.servletproject.connector;

import by.fyodorov.servletproject.exception.MailException;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        ServletContext context = getServletContext();
        String filename = context.getInitParameter("fileName");
        String root = context.getRealPath("");

        LOGGER.info(root + filename);

        FileReader reader = new FileReader(root + filename);
        int code = reader.read();
        reader.close();

        request.setAttribute("res", Character.toString((char)code));
        LOGGER.info("read " + code + " from file");

        Part filePart = request.getPart("file");
        Path path = Paths.get(filePart.getSubmittedFileName());
        LOGGER.info("input = \"" + path.toAbsolutePath() + "\"");
        String uploadFileName = path.getFileName().toString();

        LOGGER.info("getting file = \"" + uploadFileName + "\"");

        String cloneName = context.getInitParameter("cloneName");
        InputStream fileContent = filePart.getInputStream();
        File outputFile = new File(root + cloneName);
        FileUtils.copyInputStreamToFile(fileContent, outputFile);
        LOGGER.info("output file = \"" + outputFile.getAbsolutePath() + "\"");

        String lang = request.getParameter("language");
        LOGGER.info(lang);
        request.setAttribute("language", lang);

        sendMail(root, "TEST");

        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    private void sendMail(String path, String text) {
        try {
            MailAdapter adapter = new MailAdapter(path);
            adapter.send(text, "Fyodorov.aleksej@gmail.com");
        }
        catch (MailException e) {
            LOGGER.catching(e);
        }
    }


}
