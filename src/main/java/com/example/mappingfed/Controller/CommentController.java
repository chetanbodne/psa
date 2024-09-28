package com.example.mappingfed.Controller;

import com.example.mappingfed.enity.Comment;
import com.example.mappingfed.enity.Post;
import com.example.mappingfed.repository.BusRepository;
import com.example.mappingfed.repository.CommentRepository;
import com.example.mappingfed.repository.PostRepository;
import com.example.mappingfed.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    private PostRepository postRepository;
    private CommentRepository commentRepository;


    public CommentController(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;

    }

    @Autowired
    private CommentService commentService;


    @PostMapping
    public ResponseEntity<Comment>createComment(@RequestParam long postId, @RequestBody Comment comment){

        Post post = postRepository.findById(postId).get();
        comment.setPost(post);

        return ResponseEntity.ok(commentRepository.save(comment));
    }
    @PostMapping("/rahul")
    public ResponseEntity<Comment>createCommentss(@RequestParam Long postId, @RequestBody Comment comment) {
        Comment comment1 = commentService.create(postId, comment);
        return new ResponseEntity<>(comment1, HttpStatus.CREATED);
    }
}

