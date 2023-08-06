package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.UserDaoImpl;
import models.User;
import services.RegistrationServiceImpl;
import services.RegistrationServices;


@WebServlet("")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	session.setAttribute("userType", session.getAttribute("userType"));
    	System.out.println(session.getAttribute("userType"));
        request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
        
    }
    
   
}
