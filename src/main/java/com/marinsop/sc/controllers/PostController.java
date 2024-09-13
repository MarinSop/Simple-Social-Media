package com.marinsop.sc.controllers;

import com.marinsop.sc.dtos.PostDTO;
import com.marinsop.sc.entities.Post;
import com.marinsop.sc.entities.User;
import com.marinsop.sc.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/posts")
@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> findAllByUserId(@PathVariable("userId") int userId)
    {
        return ResponseEntity.ok(postService.findAllByUserId(userId));
    }

    @PostMapping("")
    public ResponseEntity<Post> addPost(@AuthenticationPrincipal User user, @RequestBody PostDTO post)
    {
        return ResponseEntity.ok(postService.addPost(user, post));
    }

    @PutMapping("")
    public ResponseEntity<Post> editPost(@AuthenticationPrincipal User user, @RequestBody PostDTO post)
    {
        return ResponseEntity.ok(postService.editPost(user, post));
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<Post> deletePost(@AuthenticationPrincipal User user,@PathVariable("postId") int postId)
    {
        return ResponseEntity.ok(postService.deletePost(user, postId));
    }


}
