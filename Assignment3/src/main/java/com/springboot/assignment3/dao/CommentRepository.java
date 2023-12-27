package com.springboot.assignment3.dao;

import com.springboot.assignment3.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}