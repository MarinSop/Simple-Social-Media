package com.marinsop.sc.controllers;

import com.marinsop.sc.dtos.CommentDTO;
import com.marinsop.sc.entities.Comment;
import com.marinsop.sc.entities.User;
import com.marinsop.sc.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/comments")
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Comment>> findAllPostComments(@PathVariable("postId") int postId)
    {
        return ResponseEntity.ok(commentService.findAllPostComments(postId));
    }

    @PostMapping("/post/{postId}")
    public ResponseEntity<Comment> addCommentToPost(@AuthenticationPrincipal User user, @PathVariable("postId") int postId, @RequestBody CommentDTO comment)
    {
        return ResponseEntity.ok(commentService.addCommentToPost(user,postId,comment));
    }

    @PutMapping("")
    public ResponseEntity<Comment> editComment(@AuthenticationPrincipal User user, @RequestBody Comment editedComment)
    {
        return ResponseEntity.ok(commentService.editComment(user.getId(), editedComment));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Comment> deleteComment(@AuthenticationPrincipal User user, @PathVariable("commentId") int commentId)
    {
        return ResponseEntity.ok(commentService.deleteComment(user.getId(),commentId));
    }
}
