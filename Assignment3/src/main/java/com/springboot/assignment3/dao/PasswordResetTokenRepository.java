package com.springboot.assignment3.dao;

import com.springboot.assignment3.entity.User;
import com.springboot.assignment3.password.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    PasswordResetToken findByToken(String token);
    PasswordResetToken findByUserId(int id);
}