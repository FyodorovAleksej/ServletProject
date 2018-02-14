package by.fyodorov.servletproject.connector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        int a = Integer.valueOf(request.getParameter("aValue"));
        int b = Integer.valueOf(request.getParameter("bValue"));
        LOGGER.info("getting params: a = " + a + "; b = " + b);
        request.setAttribute("res", Integer.toString(a + b));
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
