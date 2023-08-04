package services;

import dao.UserDao;
import models.User;

public class RegistrationServiceImpl implements RegistrationServices{
	private final UserDao userDao;

    public RegistrationServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void registerUser(User user) {
        userDao.registerUser(user);
    }
	

}
