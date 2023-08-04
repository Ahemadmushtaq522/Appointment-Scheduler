package services;

import dao.UserDao;
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
    public User getUserByEmailAndPassword(String email, String password) {
        return userDao.getUserByEmailAndPassword(email, password);
    }
}
