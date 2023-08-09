package controllers;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import dao.UserDao;
//import dao.UserDaoImpl;
//import models.Appointments;
//import services.RegistrationServiceImpl;
//import services.RegistrationServices;
//import util.ExcelReportGenerator;
//
//@WebServlet("/admin/generate-report")
//public class GenerateReportServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String action = request.getParameter("action");
//        
//        UserDao userDao = new UserDaoImpl();
//	     RegistrationServices service = new RegistrationServiceImpl(userDao);
//        
//        if ("generate-report".equals(action)) {
//            String selectedMonth = request.getParameter("selectedMonth");
//            // Get appointments data for the selected month
//            List<Appointments> appointments = service.getAppointmentDataForMonth(selectedMonth);
//
//            ExcelReportGenerator reportGenerator = new ExcelReportGenerator();
//            try {
//                reportGenerator.generateExcelReport(appointments, selectedMonth);
//                request.setAttribute("reportMessage", "Report generated successfully!");
//            } catch (IOException e) {
//                e.printStackTrace();
//                request.setAttribute("reportMessage", "Failed to generate report.");
//            }
//
//            request.getRequestDispatcher("/WEB-INF/views/admin/reports.jsp").forward(request, response);
//        } else {
//            response.sendError(HttpServletResponse.SC_NOT_FOUND);
//        }
//    }
//
//}

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;
import models.Appointments;
import services.RegistrationServiceImpl;
import services.RegistrationServices;
//...
import util.PDFReportGenerator;

@WebServlet("/admin/generate-report")
public class GenerateReportServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

 protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
     String action = request.getParameter("action");
     
     UserDao userDao = new UserDaoImpl();
	    RegistrationServices service = new RegistrationServiceImpl(userDao);
     
     if ("generate-report".equals(action)) {
         String selectedMonth = request.getParameter("selectedMonth");
         // Get appointments data for the selected month
         List<Appointments> appointments = service.getAppointmentDataForMonth(selectedMonth);

         PDFReportGenerator reportGenerator = new PDFReportGenerator();
         try {
             reportGenerator.generatePDFReport(appointments, selectedMonth);
             request.setAttribute("reportMessage", "Report generated successfully!");
         } catch (IOException e) {
             e.printStackTrace();
             request.setAttribute("reportMessage", "Failed to generate report.");
         }

         request.getRequestDispatcher("/WEB-INF/views/admin/reports.jsp").forward(request, response);
     } else {
         response.sendError(HttpServletResponse.SC_NOT_FOUND);
     }
 }
}
