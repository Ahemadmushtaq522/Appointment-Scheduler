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
import models.User;
import services.RegistrationServiceImpl;
import services.RegistrationServices;

@WebServlet("/admin/*")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public AdminServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean loggedIn = session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn");
        UserDao userDao = new UserDaoImpl();
        RegistrationServices service = new RegistrationServiceImpl(userDao);
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String mobile = request.getParameter("mobile");
    	
        int totalAppointments = service.getTotalAppointments();
        int totalClients = service.getTotalClients();
        int totalConsultants = service.getTotalConsultants();

        request.setAttribute("totalAppointments", totalAppointments);
        request.setAttribute("totalClients", totalClients);
        request.setAttribute("totalConsultants", totalConsultants);
        
        if (loggedIn) {
            String pathInfo = request.getPathInfo();
            
            if (pathInfo == null) {
                request.getRequestDispatcher("/WEB-INF/views/admin/adminHome.jsp").forward(request, response);
            } else if ("/clients".equals(pathInfo)) {
                List<User> jobSeekers = service.getAllJobSeekers();
                request.setAttribute("jobSeekers", jobSeekers);
                request.getRequestDispatcher("/WEB-INF/views/admin/clients.jsp").forward(request, response);
            } else if ("/consultants".equals(pathInfo)) {
                List<Consultant> consultants = service.getAllConsultants();
                request.setAttribute("consultants", consultants);
                request.getRequestDispatcher("/WEB-INF/views/admin/consultants.jsp").forward(request, response);
            } else if ("/appointments".equals(pathInfo)) {
                List<Appointments> appointments = service.getAllAppointments();
                request.setAttribute("appointments", appointments);
                request.getRequestDispatcher("/WEB-INF/views/admin/appointments.jsp").forward(request, response);
            } else if("/addnew".equals(pathInfo)) {
            	request.getRequestDispatcher("/WEB-INF/views/admin/addnew.jsp").forward(request, response);
            } else if ("/reports".equals(pathInfo)) {
                request.getRequestDispatcher("/WEB-INF/views/admin/reports.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        
        String pathInfo = request.getPathInfo();
        UserDao userDao = new UserDaoImpl();
        RegistrationServices service = new RegistrationServiceImpl(userDao);
        
        if ("/consultant/delete".equals(pathInfo)) {
            String cemail = request.getParameter("consultantemail");
            
            System.out.println(service.deleteByConsultantEmail(cemail));
            response.sendRedirect(request.getContextPath() + "/admin/consultants");
        }else if("/client/delete".equals(pathInfo)){
        	String uemail = request.getParameter("jobseekeremail");  
            System.out.println(service.deleteByUserEmail(uemail));
            response.sendRedirect(request.getContextPath() + "/admin/clients");
        }else{
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    
}
