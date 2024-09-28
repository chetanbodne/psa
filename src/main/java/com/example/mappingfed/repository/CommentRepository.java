package com.example.mappingfed.repository;

import com.example.mappingfed.enity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}