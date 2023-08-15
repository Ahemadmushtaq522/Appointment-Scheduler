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

        
      //-----------validate User--------------------------//

        UserDao userDao = new UserDaoImpl();
        RegistrationServices service = new RegistrationServiceImpl(userDao);
        boolean userExists = service.isUserExistsByEmail(email);
        HttpSession session = request.getSession();
        String userType = (String) session.getAttribute("userType");

        if (userExists) {
            request.setAttribute("errorMessage", "User with this email already exists.");
            session.setAttribute("visistedWelcomePage", true);
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
            return;
        }

        // If the user does not exist, proceed with password validation and user creation
        if (!password.equals(password2)) {
            request.setAttribute("errorMessage", "Passwords do not match.");
            session.setAttribute("visistedWelcomePage", true);
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
            return;
        }
        
        if(password.length() <8) {
        	request.setAttribute("errorMessage", "Invalid password length.");
            session.setAttribute("visistedWelcomePage", true);
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
            return;
        }
        
        
        //------------------Entering data----------------------//
        
        
        if(userType.equals("Job Hunter")) {
        	User user = new User(username, email,password,mobile);
        	System.out.println(service.registerUser(user));
        	session.setAttribute("visistedWelcomePage", true);
        	response.sendRedirect(request.getContextPath() + "/login");
        }else {
	        response.sendError(HttpServletResponse.SC_NOT_FOUND);
	    }
 
    }

}
