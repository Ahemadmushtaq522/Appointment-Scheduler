package dao;

import models.User;

public interface UserDao {
	String registerUser(User user);
	User getUserByEmailAndPassword(String email, String password);
}
