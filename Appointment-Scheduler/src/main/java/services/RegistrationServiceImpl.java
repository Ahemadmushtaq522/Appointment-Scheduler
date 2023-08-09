package services;

import java.util.List;

import controllers.AdminServlet;
import dao.UserDao;
import models.Admin;
import models.Appointments;
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

	@Override
	public List<User> getAllJobSeekers() {
		return userDao.getAllJobSeekers();
	}

	@Override
	public List<Consultant> getAllConsultants() {
		return userDao.getAllConsultants();
	}

	@Override
	public String getUserMobileByUsername(String username) {
		return userDao.getUserMobileByUsername(username);
	}

	@Override
	public String makeAppointment(Appointments appointment) {
		return userDao.makeAppointment(appointment);
		
	}

	@Override
	public List<Appointments> getAllAppointments() {
		return userDao.getAllAppointments();
	}

	@Override
	public String deleteByConsultantEmail(String email) {
		return userDao.deleteByConsultantEmail(email);
	}

	@Override
	public boolean isUserExistsByEmail(String email) {
		return userDao.isUserExistsByEmail(email);
	}

	@Override
	public String deleteByUserEmail(String uemail) {
		return userDao.deleteByUserEmail(uemail);
	}

	@Override
	public String getUserEmaileByUsername(String username) {
		return userDao.getUserEmaileByUsername(username);
	}

	@Override
	public int getTotalAppointments() {
		return userDao.getTotalAppointments();
	}

	@Override
	public int getTotalClients() {
		return userDao.getTotalClients();
	}

	@Override
	public int getTotalConsultants() {
		return userDao.getTotalConsultants();
	}

	@Override
	public List<Appointments> getAppointmentDataForMonth(String selectedMonth) {
		return userDao.getAppointmentDataForMonth(selectedMonth);
	}
}
