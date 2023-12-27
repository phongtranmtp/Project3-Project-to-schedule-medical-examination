package com.springboot.assignment3.password;

import com.springboot.assignment3.entity.User;
import com.springboot.assignment3.model.UserDTO;

import java.util.List;
import java.util.Optional;

public interface PasswordResetTokenService {
    void createPasswordResetTokenForUser(User user, String passwordToken);

    String validatePasswordResetToken(String passwordResetToken);

    Optional<User> findUserByPasswordToken(String passwordResetToken);

}
