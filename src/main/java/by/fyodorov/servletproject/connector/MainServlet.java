package by.fyodorov.servletproject.connector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.catching(e);
        }

        Part filePart = null;
        try {
            filePart = request.getPart("file");
            Path path = Paths.get(filePart.getSubmittedFileName());
            LOGGER.info("input = \"" + path.toAbsolutePath() + "\"");
            String uploadFileName = path.getFileName().toString();

            LOGGER.info("getting file = \"" + uploadFileName + "\"");

            request.getRequestDispatcher("/pages/result.jsp").forward(request, response);
        } catch (IOException e) {
            LOGGER.catching(e);
        } catch (ServletException e) {
            LOGGER.catching(e);
        }
    }
}
