package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/*")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
   
    public AdminServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            // Default behavior, e.g., displaying admin home
            request.getRequestDispatcher("/WEB-INF/views/admin/adminHome.jsp").forward(request, response);
        } else if ("/clients".equals(pathInfo)) {
            // Handle services page
            request.getRequestDispatcher("/WEB-INF/views/admin/clients.jsp").forward(request, response);
        } else if ("/consultants".equals(pathInfo)) {
            // Handle consultants page
            request.getRequestDispatcher("/WEB-INF/views/admin/consultants.jsp").forward(request, response);
        } else if ("/appointments".equals(pathInfo)) {
            // Handle consultants page
            request.getRequestDispatcher("/WEB-INF/views/admin/appointments.jsp").forward(request, response);
        }else if ("/reports".equals(pathInfo)) {
            // Handle consultants page
            request.getRequestDispatcher("/WEB-INF/views/admin/reports.jsp").forward(request, response);
        }else {
            // Handle other cases or show an error page
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}

