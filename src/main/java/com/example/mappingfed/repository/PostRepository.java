package com.example.mappingfed.repository;

import com.example.mappingfed.enity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p where p.id = ?1")
    Optional<Post> findById(Long postId);
}