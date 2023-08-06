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
import models.Admin;
import models.Consultant;
import models.User;
import services.RegistrationServiceImpl;
import services.RegistrationServices;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        String userType = (String) session.getAttribute("userType");
        
        UserDao userDao = new UserDaoImpl();
        RegistrationServices service = new RegistrationServiceImpl(userDao);
       
        
        if("Job Hunter".equals(userType)) {
        	User user = service.getUserByEmailAndPassword(email, password);
        	if(user != null) {
        		session.setAttribute("username", user.getUsername());
            	session.setAttribute("loggedIn", true);
        		response.sendRedirect(request.getContextPath() + "/jobseeker");
        	}

            else {
            	request.setAttribute("error", "Invalid username or password");
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
            }
        }else if("Consultant".equals(userType)) {
        	Consultant consultant = service.getConsultantByEmailAndPassword(email, password);
        	if(consultant != null) {
        		session.setAttribute("username", consultant.getUsername());
            	session.setAttribute("loggedIn", true);
        		response.sendRedirect(request.getContextPath() + "/consultant");
        	}

            else {
            	request.setAttribute("error", "Invalid username or password");
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
            }
        }else if("Administrator".equals(userType)) {
        	Admin admin = service.getAdminByEmailAndPassword(email, password);
        	if(admin != null) {
        		session.setAttribute("username", admin.getUsername());
            	session.setAttribute("loggedIn", true);
        		response.sendRedirect(request.getContextPath() + "/admin");
        	}

            else {
            	request.setAttribute("error", "Invalid username or password");
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
            }
        }
        
       


        
    }
    
}
