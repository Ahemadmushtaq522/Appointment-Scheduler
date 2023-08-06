package dao;

import models.Admin;
import models.Consultant;
import models.User;

public interface UserDao {
	String registerUser(User user);
	String registerAdmin(Admin admin);
	String registerConsultant(Consultant consultant);
	User getUserByEmailAndPassword(String email, String password);
	Consultant getConsultantByEmailAndPassword(String email, String password);
	Admin getAdminByEmailAndPassword(String email, String password);
	
}
