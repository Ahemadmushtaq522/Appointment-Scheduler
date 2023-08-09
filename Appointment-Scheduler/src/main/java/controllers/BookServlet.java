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
import services.RegistrationServiceImpl;
import services.RegistrationServices;
import util.EmailUtility;

@WebServlet("/jobseeker/appointments")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BookServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao = new UserDaoImpl();
        RegistrationServices userService = new RegistrationServiceImpl(userDao);
		 List<Appointments> appointments = userService.getAllAppointments();
     	System.out.println("appointments : "+appointments);
     	request.setAttribute("appointments", appointments);
		request.getRequestDispatcher("/WEB-INF/views/jobseeker/appointments.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String appointmentDate = request.getParameter("appointmentDate");
		    String appointmentTime = request.getParameter("appointmentTime");
		    String consultantUsername = request.getParameter("consultantUsername");
		    String consultantEmail = request.getParameter("consultantEmail");
		    String consultantMobile = request.getParameter("consultantMobile");
		   
		    System.out.println("appointmentDate: " + appointmentDate);
		    System.out.println("appointmentTime: " + appointmentTime);
		    System.out.println("consultantUsername: " + consultantUsername);
		    System.out.println("consultantEmail: " + consultantEmail);
		    System.out.println("consultantMobile: " + consultantMobile);
		    HttpSession session = request.getSession();
		    String username = (String) session.getAttribute("username");
		 
		    
		    UserDao userDao = new UserDaoImpl();
	        RegistrationServices userService = new RegistrationServiceImpl(userDao);
	        String usermobile = userService.getUserMobileByUsername(username);
	        String uemail = userService.getUserEmaileByUsername(username);
	        
	        Appointments appointment = new Appointments(username,usermobile,consultantUsername,consultantMobile,appointmentDate,appointmentTime);
	        System.out.println(userService.makeAppointment(appointment));
	   
	        List<Appointments> appointments = userService.getAllAppointments();
        	System.out.println("appointments : "+appointments);
        	
        	//sending and email to both consultant and client
//        	EmailUtility.sendAppointmentConfirmation(consultantEmail, uemail);
        	
        	
        	request.setAttribute("appointments", appointments);
		    request.getRequestDispatcher("/WEB-INF/views/jobseeker/appointments.jsp").forward(request, response);
	}

}
