package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

import models.Appointments;

public class ExcelReportGenerator {

	public void generateExcelReport(List<Appointments> appointments, String month) throws IOException {
	    XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet("Appointment Report");

	    // Create header row
	    Row headerRow = sheet.createRow(0);
	    headerRow.createCell(0).setCellValue("Appointment Date");
	    headerRow.createCell(1).setCellValue("Appointment Time");
	    // ... Add more columns as needed

	    // Populate data rows
	    int rowNum = 1;
	    for (Appointments appointment : appointments) {
	        Row row = sheet.createRow(rowNum++);
	        row.createCell(0).setCellValue(appointment.getAppointmentDate());
	        row.createCell(1).setCellValue(appointment.getAppointmentTime());
	        // ... Populate other columns with appointment details
	    }

	    // Save the workbook to a file
	    try (FileOutputStream outputStream = new FileOutputStream("Appointment_Report_" + month + ".xlsx")) {
	        workbook.write(outputStream);
	    }
	}

}
