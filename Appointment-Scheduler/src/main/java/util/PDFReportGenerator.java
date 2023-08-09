package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import models.Appointments;

public class PDFReportGenerator {

    public void generatePDFReport(List<Appointments> appointments, String month) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream("Appointment_Report_" + month + ".pdf")) {
            StringBuilder reportContent = new StringBuilder();
            reportContent.append("Appointment Report for ").append(month).append("\n\n");

            for (Appointments appointment : appointments) {
                reportContent.append("Appointment Date: ").append(appointment.getAppointmentDate()).append("\n");
                reportContent.append("Appointment Time: ").append(appointment.getAppointmentTime()).append("\n");
                reportContent.append("Consultant name: ").append(appointment.getConsultantName()).append("\n");
                reportContent.append("Consultant mobile: ").append(appointment.getConsultantMobile()).append("\n");
                reportContent.append("Client name: ").append(appointment.getUsername()).append("\n");
                reportContent.append("Client mobile: ").append(appointment.getUserMobile()).append("\n");
                reportContent.append("\n");
                // Add more details as needed
            }

            outputStream.write(reportContent.toString().getBytes());
        }
    }
}
