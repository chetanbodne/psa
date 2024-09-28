package com.example.mappingfed.Controller;

import com.example.mappingfed.enity.Post;
import com.example.mappingfed.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")

public class PostController {
    private PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<Post>createPost(@RequestBody Post post){
        Post post1 = postRepository.save(post);
        return new ResponseEntity<>(post1, HttpStatus.CREATED);

    }

}
