package com.example.mappingfed.service;

import com.example.mappingfed.enity.Post;
import com.example.mappingfed.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    public Post create(Post post){
       return postRepository.save(post);
    }
}
