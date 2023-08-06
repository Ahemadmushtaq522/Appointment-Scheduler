package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/admin/*")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
   
    public AdminServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean loggedIn = session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn");

        if (loggedIn) {
            String pathInfo = request.getPathInfo();
            
            if (pathInfo == null) {
                request.getRequestDispatcher("/WEB-INF/views/admin/adminHome.jsp").forward(request, response);
            } else if ("/clients".equals(pathInfo)) {
                request.getRequestDispatcher("/WEB-INF/views/admin/clients.jsp").forward(request, response);
            } else if ("/consultants".equals(pathInfo)) {
                request.getRequestDispatcher("/WEB-INF/views/admin/consultants.jsp").forward(request, response);
            } else if ("/appointments".equals(pathInfo)) {
                request.getRequestDispatcher("/WEB-INF/views/admin/appointments.jsp").forward(request, response);
            } else if ("/reports".equals(pathInfo)) {
                request.getRequestDispatcher("/WEB-INF/views/admin/reports.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
