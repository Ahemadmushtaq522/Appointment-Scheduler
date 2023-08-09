package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.UserDaoImpl;
import models.Appointments;
import models.Consultant;
import services.RegistrationServiceImpl;
import services.RegistrationServices;


@WebServlet("/jobseeker/*")
public class JobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public JobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String pathInfo = request.getPathInfo();
		 UserDao userDao = new UserDaoImpl();
		 RegistrationServices service = new RegistrationServiceImpl(userDao);
		 int totalAppointments = service.getTotalAppointments();
	        int totalClients = service.getTotalClients();
	        int totalConsultants = service.getTotalConsultants();

	        request.setAttribute("totalAppointments", totalAppointments);
	        request.setAttribute("totalClients", totalClients);
	        request.setAttribute("totalConsultants", totalConsultants);

	        if (pathInfo == null) {
	            request.getRequestDispatcher("/WEB-INF/views/jobseeker/jobhome.jsp").forward(request, response);
	        } else if ("/consultants".equals(pathInfo)) {
	        	List<Consultant> consultants = service.getAllConsultants();
            	System.out.println("consultants : "+consultants);
            	request.setAttribute("consultants", consultants);
	            request.getRequestDispatcher("/WEB-INF/views/jobseeker/consultants.jsp").forward(request, response);
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
