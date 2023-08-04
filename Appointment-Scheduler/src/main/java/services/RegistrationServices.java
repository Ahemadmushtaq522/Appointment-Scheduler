package services;

import models.User;

public interface RegistrationServices {
    String registerUser(User user);
    User getUserByEmailAndPassword(String email, String password);
}
