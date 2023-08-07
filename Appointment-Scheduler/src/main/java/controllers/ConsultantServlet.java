package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;
import models.User;
import services.RegistrationServiceImpl;
import services.RegistrationServices;


@WebServlet("/consultant/*")
public class ConsultantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ConsultantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String pathInfo = request.getPathInfo();
		 UserDao userDao = new UserDaoImpl();
	     RegistrationServices service = new RegistrationServiceImpl(userDao);
		 
		 
	        if (pathInfo == null) {
	            request.getRequestDispatcher("/WEB-INF/views/consultant/consultantHome.jsp").forward(request, response);
	        } else if ("/clients".equals(pathInfo)) {
	        	List<User> jobSeekers = service.getAllJobSeekers();
            	System.out.println("jobseekers : "+jobSeekers);
            	request.setAttribute("jobSeekers", jobSeekers);
	            request.getRequestDispatcher("/WEB-INF/views/consultant/clients.jsp").forward(request, response);
	        } else if ("/appointments".equals(pathInfo)) {
	            request.getRequestDispatcher("/WEB-INF/views/consultant/appointments.jsp").forward(request, response);
	        }else if ("/profile".equals(pathInfo)) {
	            request.getRequestDispatcher("/WEB-INF/views/consultant/profile.jsp").forward(request, response);
	        }else {
	            response.sendError(HttpServletResponse.SC_NOT_FOUND);
	        }
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		doGet(request, response);
//	}

}
