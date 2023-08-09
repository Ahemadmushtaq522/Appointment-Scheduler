package services;

import java.util.List;

import models.Admin;
import models.Appointments;
import models.Consultant;
import models.User;

public interface RegistrationServices {
    String registerUser(User user);
    String registerConsultant(Consultant consultant);
	String registerAdmin(Admin admin);
	
    User getUserByEmailAndPassword(String email, String password);
	Consultant getConsultantByEmailAndPassword(String email, String password);
	Admin getAdminByEmailAndPassword(String email, String password);
	
	List<User> getAllJobSeekers();
	List<Consultant> getAllConsultants();
	
	String getUserMobileByUsername(String username);
	String makeAppointment(Appointments appointment);
	List<Appointments> getAllAppointments();
	String deleteByConsultantEmail(String email);
	boolean isUserExistsByEmail(String email);
	String deleteByUserEmail(String uemail);
	String getUserEmaileByUsername(String username);
	int getTotalAppointments();
	int getTotalClients();
	int getTotalConsultants();
	List<Appointments> getAppointmentDataForMonth(String selectedMonth);
	
}
