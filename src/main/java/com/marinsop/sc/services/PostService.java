package com.marinsop.sc.services;

import com.marinsop.sc.dtos.PostDTO;
import com.marinsop.sc.entities.Post;
import com.marinsop.sc.entities.User;
import com.marinsop.sc.exceptions.EntityNotFound;
import com.marinsop.sc.exceptions.InvalidTarget;
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

    public Post addPost(User user, PostDTO post)
    {
        Post newPost = new Post();
        newPost.setUser(user);
        newPost.setContent(post.getContent());
        return postRepository.save(newPost);

    }

    public Post editPost(User user, PostDTO post)
    {
        Post oldPost = postRepository.findById(post.getId()).orElseThrow(() -> new EntityNotFound("Post not found."));
        if(user.getId() != oldPost.getUser().getId())
        {
            throw new InvalidTarget("Invalid target.");
        }
        oldPost.setContent(post.getContent());
        return postRepository.save(oldPost);
    }

    public Post deletePost(User user, int postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new EntityNotFound("Post not found."));
        if (user.getId() != post.getUser().getId()) {
            throw new InvalidTarget("Invalid target.");
        }
        postRepository.delete(post);
        return post;
    }
}
