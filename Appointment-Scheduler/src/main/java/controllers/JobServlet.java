package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jobseeker/*")
public class JobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public JobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String pathInfo = request.getPathInfo();
	        if (pathInfo == null) {
	            request.getRequestDispatcher("/WEB-INF/views/jobseeker/jobhome.jsp").forward(request, response);
	        } else if ("/consultants".equals(pathInfo)) {
	            request.getRequestDispatcher("/WEB-INF/views/jobseeker/consultants.jsp").forward(request, response);
	        } else if ("/appointments".equals(pathInfo)) {
	            request.getRequestDispatcher("/WEB-INF/views/jobseeker/appointments.jsp").forward(request, response);
	        }else if ("/profile".equals(pathInfo)) {
	            request.getRequestDispatcher("/WEB-INF/views/jobseeker/profile.jsp").forward(request, response);
	        }
	        else if ("/services".equals(pathInfo)) {
	            request.getRequestDispatcher("/WEB-INF/views/jobseeker/services.jsp").forward(request, response);
	        }else {
	            response.sendError(HttpServletResponse.SC_NOT_FOUND);
	        }
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		doGet(request, response);
//	}

}
