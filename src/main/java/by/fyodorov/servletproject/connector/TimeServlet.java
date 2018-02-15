package by.fyodorov.servletproject.connector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

public class TimeServlet extends HttpServlet {

    private final Logger LOGGER = LogManager.getLogger(TimeServlet.class);

    public TimeServlet() {
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

        FileReader reader = new FileReader(root + filename);
        int code = reader.read();
        reader.close();

        request.setAttribute("res", Character.toString((char)code));
        LOGGER.info("read " + code + " from file");
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
