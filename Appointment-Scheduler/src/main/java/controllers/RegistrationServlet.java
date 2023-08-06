package controllers;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.UserDaoImpl;
import models.Admin;
import models.Consultant;
import models.User;
import services.RegistrationServiceImpl;
import services.RegistrationServices;

import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	
//	private final RegistrationServices userService;

    public RegistrationServlet() {
        // Initialize userService with appropriate UserDao implementation
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);
    }
    
   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String mobile = request.getParameter("mobile");

        
        //-----------validate password and emai---------------------------//
        
        
        
        //------------------Entering data----------------------//
        UserDao userDao = new UserDaoImpl();
        RegistrationServices userService = new RegistrationServiceImpl(userDao);
        HttpSession session = request.getSession();
        String userType = (String) session.getAttribute("userType");
        
        if(userType.equals("Job Hunter")) {
        	User user = new User(username, email,password,mobile);
        	System.out.println(userService.registerUser(user));
        	session.setAttribute("visistedWelcomePage", true);
        	response.sendRedirect(request.getContextPath() + "/login");
        }else if(userType.equals("Consultant")) {
        	Consultant consultant = new Consultant(username, email,password,mobile);
        	System.out.println(userService.registerConsultant(consultant));
        	session.setAttribute("visistedWelcomePage", true);
        	response.sendRedirect(request.getContextPath() + "/login");
        }else if(userType.equals("Administrator")) {
        	Admin admin = new Admin(username, email,password,mobile);
        	System.out.println(userService.registerAdmin(admin));
        	session.setAttribute("visistedWelcomePage", true);
        	response.sendRedirect(request.getContextPath() + "/login");
        }else {
        	session.setAttribute("visistedWelcomePage", true);
        	 response.sendRedirect(request.getContextPath() + "/login");
        }
 
    }

}
