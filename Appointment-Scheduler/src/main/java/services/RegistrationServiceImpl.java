package services;

import controllers.AdminServlet;
import dao.UserDao;
import models.Admin;
import models.Consultant;
import models.User;

public class RegistrationServiceImpl implements RegistrationServices {

    private UserDao userDao;

    public RegistrationServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String registerUser(User user) {
        return userDao.registerUser(user);
    }
    
    @Override
    public String registerConsultant(Consultant consultant) {
        return userDao.registerConsultant(consultant);
    }
    
    @Override
    public String registerAdmin(Admin admin) {
        return userDao.registerAdmin(admin);
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return userDao.getUserByEmailAndPassword(email, password);
    }

	@Override
	public Consultant getConsultantByEmailAndPassword(String email, String password) {
		return userDao.getConsultantByEmailAndPassword(email, password);
	}

	@Override
	public Admin getAdminByEmailAndPassword(String email, String password) {
		return userDao.getAdminByEmailAndPassword(email, password);
	}
}
