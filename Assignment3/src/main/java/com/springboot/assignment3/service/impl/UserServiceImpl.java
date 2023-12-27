package com.springboot.assignment3.service.impl;

import com.springboot.assignment3.dao.UserRepository;
import com.springboot.assignment3.entity.User;
import com.springboot.assignment3.model.ExceptionDTO;
import com.springboot.assignment3.model.UserDTO;
import com.springboot.assignment3.password.PasswordResetTokenService;
import com.springboot.assignment3.security.PasswordGenerator;
import com.springboot.assignment3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordResetTokenService passwordResetTokenService;

    @Override
    public UserDTO findUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        UserDTO userDTO = convertUser(user);
        return userDTO;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User addUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(PasswordGenerator.getHashString(userDTO.getPassword()));
        user.setAddress(userDTO.getAddress());
        user.setPhone(userDTO.getPhone());
        user.setAvatar(userDTO.getAvatar());
        user.setGender(userDTO.getGender());
        user.setDescription(userDTO.getDescription());
        user.setRole(userDTO.getRole());
        if (user.getRole().getId() == 1){
            user.setActive(true);
        }
        user.setActive(userDTO.isActive());
        user.setCreatedAt(userDTO.getCreatedAt());
        userRepository.save(user);
        return user;
    }

    @Override
    public void createPasswordResetTokenForUser(User user, String passwordResetToken) {
        passwordResetTokenService.createPasswordResetTokenForUser(user, passwordResetToken);
    }

    @Override
    public String validatePasswordResetToken(String passwordResetToken) {
        return passwordResetTokenService.validatePasswordResetToken(passwordResetToken);
    }

    @Override
    public User findUserByPasswordToken(String passwordResetToken) {
        return passwordResetTokenService.findUserByPasswordToken(passwordResetToken).get();
    }

    @Override
    public void resetUserPassword(User user, String newPassword) {
        user.setPassword(PasswordGenerator.getHashString(newPassword));
        userRepository.save(user);
    }

    @Override
    public User lockAndUnlockUser(UserDTO userDTO) {
        User user = userRepository.findUserByEmail(userDTO.getEmail());
        if (user.getRole().getId() != 3){
            throw new ExceptionDTO("This is not a user role") ;
        } else if (user.isActive() == false && user.getRole().getId() == 3) {
            user.setActive(true);
            user.setDescription(null);
        } else if (user.isActive() == true && user.getRole().getId() == 3) {
            user.setActive(false);
            user.setDescription(userDTO.getDescription());
        }
        userRepository.save(user);
        return user;
    }

    @Override
    public User lockAndUnlockDoctor(UserDTO userDTO) {
        User user = userRepository.findUserByEmail(userDTO.getEmail());
        if (user.getRole().getId() != 2) {
            throw new ExceptionDTO("This is not the role of a doctor ");
        } else if (user.isActive() == false && user.getRole().getId() == 2) {
            user.setActive(true);
            user.setDescription(null);
        } else if (user.isActive() == true && user.getRole().getId() == 2) {
            user.setActive(false);
            user.setDescription(userDTO.getDescription());
        }
        userRepository.save(user);
        return user;
    }

    public UserDTO convertUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(PasswordGenerator.getHashString(user.getPassword()));
        userDTO.setAddress(user.getAddress());
        userDTO.setPhone(user.getPhone());
        userDTO.setAvatar(user.getAvatar());
        userDTO.setGender(user.getGender());
        userDTO.setDescription(user.getDescription());
        userDTO.setRole(user.getRole());
        userDTO.setActive(user.isActive());
        userDTO.setCreatedAt(user.getCreatedAt());
        return userDTO;
    }
}
