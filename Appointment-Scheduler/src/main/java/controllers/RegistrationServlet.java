package controllers;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
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

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setMobile(mobile);
        
        
        System.out.println(username);

//        userService.registerUser(user);

        response.sendRedirect(request.getContextPath() + "/login");
    }

}
