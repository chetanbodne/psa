package com.example.mappingfed.service;

import com.example.mappingfed.enity.Comment;
import com.example.mappingfed.enity.Post;
import com.example.mappingfed.repository.CommentRepository;
import com.example.mappingfed.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    public Comment create(Long postId,Comment comment){
        Post post = postRepository.findById(postId).orElseThrow(()-> new RuntimeException("oijsoijsiogj"));
                //.orElseThrow(() -> new RuntimeException("oifijfiwefjof"));
//        try{
//            comment.setPost(post.get());
//            return commentRepository.save(comment);
//        }catch (Exception e){
//            System.out.println(e);
//        }
        comment.setPost(post);
        return commentRepository.save(comment);
    }
}
