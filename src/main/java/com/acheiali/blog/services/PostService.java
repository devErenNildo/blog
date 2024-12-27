package com.acheiali.blog.services;

import com.acheiali.blog.domain.post.Post;
import com.acheiali.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public Post addPost(Post post){
        return postRepository.save(post);
    }
}
