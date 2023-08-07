package services;

import java.util.List;

import models.Admin;
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
	
}
