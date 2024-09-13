package com.marinsop.sc.services;

import com.marinsop.sc.entities.Comment;
import com.marinsop.sc.entities.Post;
import com.marinsop.sc.entities.ULike;
import com.marinsop.sc.entities.User;
import com.marinsop.sc.exceptions.EntityNotFound;
import com.marinsop.sc.exceptions.InvalidTarget;
import com.marinsop.sc.repositories.CommentRepository;
import com.marinsop.sc.repositories.PostRepository;
import com.marinsop.sc.repositories.ULikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ULikeService {
    @Autowired
    private ULikeRepository uLikeRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    public List<ULike> findAllPostLikes(int postId)
    {
        postRepository.findById(postId).orElseThrow(() -> new EntityNotFound("Post not found."));
        return uLikeRepository.findAllByPostId(postId);
    }

    public List<ULike> findAllCommentLikes(int commentId)
    {
        postRepository.findById(commentId).orElseThrow(() -> new EntityNotFound("Post not found."));
        return uLikeRepository.findAllByCommentId(commentId);
    }

    public ULike likePost(User user, int postId)
    {
        Post post = postRepository.findById(postId).orElseThrow(() -> new EntityNotFound("Post not found."));
        ULike like = new ULike();
        like.setPost(post);
        like.setUser(user);
        return uLikeRepository.save(like);
    }

    public ULike likeComment(User user, int commentId)
    {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new EntityNotFound("Comment not found."));
        ULike like = new ULike();
        like.setComment(comment);
        like.setUser(user);
        return uLikeRepository.save(like);
    }

    public ULike deleteLike(User user, int likeId)
    {
        ULike like = uLikeRepository.findById(likeId).orElseThrow(() -> new EntityNotFound("Like not found."));
        if(like.getUser().getId() != user.getId())
        {
            throw new InvalidTarget("Invalid target.");
        }
        uLikeRepository.delete(like);
        return like;
    }
}
