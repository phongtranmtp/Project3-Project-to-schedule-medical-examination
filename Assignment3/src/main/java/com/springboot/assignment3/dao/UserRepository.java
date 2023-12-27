package com.springboot.assignment3.dao;

import com.springboot.assignment3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmail(String email);

    boolean existsByEmail(String email);

    User findByEmail(String email);
}