package com.springboot.assignment3.service;

import com.springboot.assignment3.entity.User;
import com.springboot.assignment3.model.UserDTO;

import java.util.Optional;

public interface UserService {
    UserDTO findUserByEmail(String email);

    User findByEmail(String email);

    boolean existsByEmail(String email);

    User addUser(UserDTO userDTO);

    void createPasswordResetTokenForUser(User user, String passwordResetToken);


    String validatePasswordResetToken(String passwordResetToken);


    User findUserByPasswordToken(String passwordResetToken);

    void resetUserPassword(User user, String newPassword);

    User lockAndUnlockUser(UserDTO userDTO);

    User lockAndUnlockDoctor(UserDTO userDTO);
}
