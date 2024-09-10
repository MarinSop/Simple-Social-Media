package com.marinsop.sc.services;

import com.marinsop.sc.dtos.CommentDTO;
import com.marinsop.sc.entities.Comment;
import com.marinsop.sc.entities.Post;
import com.marinsop.sc.entities.User;
import com.marinsop.sc.exceptions.CommentNotFound;
import com.marinsop.sc.exceptions.InvalidTarget;
import com.marinsop.sc.exceptions.PostNotFound;
import com.marinsop.sc.repositories.CommentRepository;
import com.marinsop.sc.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public List<Comment> findAllPostComments(int postId)
    {
        postRepository.findById(postId).orElseThrow(() -> new PostNotFound("Post not found."));
        return commentRepository.findAllByPostId(postId);
    }

    public Comment addCommentToPost(User user, int postId, CommentDTO comment)
    {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFound("Post not found."));
        Comment newComment = new Comment();
        newComment.setContent(comment.getContent());
        newComment.setUser(user);
        newComment.setPost(post);
        System.out.println(newComment);
        return commentRepository.save(newComment);

    }

    public Comment editComment(int userId, Comment newComment)
    {
        Comment comment = commentRepository.findById(newComment.getId()).orElseThrow(() -> new CommentNotFound("Comment not found."));
        if(newComment.getUser().getId() != userId)
        {
            throw new InvalidTarget("Invalid user id.");
        }
        comment.setContent(newComment.getContent());
        return commentRepository.save(comment);


    }

    public Comment deleteComment(int userId, int commentId)
    {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new CommentNotFound("Comment not found."));
        if(comment.getUser().getId() != userId)
        {
            throw new InvalidTarget("Invalid user id.");
        }
        commentRepository.delete(comment);
        return comment;
    }
}
