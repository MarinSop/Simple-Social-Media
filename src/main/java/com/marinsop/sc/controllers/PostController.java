package com.marinsop.sc.controllers;

import com.marinsop.sc.entities.Post;
import com.marinsop.sc.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> findAllByUserId(@PathVariable("userId") int userId)
    {
        return ResponseEntity.ok(postService.findAllByUserId(userId));
    }


}
