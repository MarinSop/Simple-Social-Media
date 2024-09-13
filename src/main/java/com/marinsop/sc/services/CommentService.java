package com.marinsop.sc.services;

import com.marinsop.sc.dtos.CommentDTO;
import com.marinsop.sc.entities.Comment;
import com.marinsop.sc.entities.Post;
import com.marinsop.sc.entities.User;
import com.marinsop.sc.exceptions.EntityNotFound;
import com.marinsop.sc.exceptions.InvalidTarget;
import com.marinsop.sc.repositories.CommentRepository;
import com.marinsop.sc.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    public List<Comment> findAllPostComments(int postId)
    {
        postRepository.findById(postId).orElseThrow(() -> new EntityNotFound("Post not found."));
        return commentRepository.findAllByPostId(postId);
    }

    @Transactional
    public Comment addCommentToPost(User user, CommentDTO comment)
    {
        Post post = postRepository.findById(comment.getPostId()).orElseThrow(() -> new EntityNotFound("Post not found."));
        Comment newComment = new Comment();
        newComment.setContent(comment.getContent());
        newComment.setUser(user);
        newComment.setPost(post);
        return commentRepository.save(newComment);

    }

    public Comment editComment(User user, CommentDTO newComment)
    {
        Comment comment = commentRepository.findById(newComment.getId()).orElseThrow(() -> new EntityNotFound("Comment not found."));
        if(newComment.getUserId() != user.getId())
        {
            throw new InvalidTarget("Invalid user id.");
        }
        comment.setContent(newComment.getContent());
        return commentRepository.save(comment);


    }

    public Comment deleteComment(int userId, int commentId)
    {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new EntityNotFound("Comment not found."));
        if(comment.getUser().getId() != userId)
        {
            throw new InvalidTarget("Invalid user id.");
        }
        commentRepository.delete(comment);
        return comment;
    }
}
