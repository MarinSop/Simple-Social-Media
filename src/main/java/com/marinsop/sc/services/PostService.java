package com.marinsop.sc.services;

import com.marinsop.sc.entities.Post;
import com.marinsop.sc.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> findAllByUserId(int userId)
    {
        return postRepository.findAllByUserId(userId);
    }

}
