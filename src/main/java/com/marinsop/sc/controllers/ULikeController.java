package com.marinsop.sc.controllers;

import com.marinsop.sc.entities.ULike;
import com.marinsop.sc.entities.User;
import com.marinsop.sc.services.ULikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/likes")
@RestController
public class ULikeController {
    @Autowired
    private ULikeService uLikeService;

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<ULike>> findAllPostLikes(@PathVariable("postId") int postId)
    {
        return ResponseEntity.ok(uLikeService.findAllPostLikes(postId));
    }

    @GetMapping("/comment/{commentId}")
    public ResponseEntity<List<ULike>> findAllCommentLikes(@PathVariable("commentId") int commentId)
    {
        return ResponseEntity.ok(uLikeService.findAllCommentLikes(commentId));
    }

    @PostMapping("/post/{postId}")
    public ResponseEntity<ULike> likePost(@AuthenticationPrincipal User user, @PathVariable("postId") int postId)
    {
        return ResponseEntity.ok(uLikeService.likePost(user, postId));
    }

    @PostMapping("/comment/{commentId}")
    public ResponseEntity<ULike> likeComment(@AuthenticationPrincipal User user, @PathVariable("commentId") int commentId)
    {
        return ResponseEntity.ok(uLikeService.likeComment(user, commentId));
    }

    @DeleteMapping("{likeId}")
    public ResponseEntity<ULike> deleteLike(@AuthenticationPrincipal User user, @PathVariable("likeId") int likeId)
    {
        return ResponseEntity.ok(uLikeService.deleteLike(user, likeId));
    }
}
