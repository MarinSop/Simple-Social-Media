package com.marinsop.sc.repositories;

import com.marinsop.sc.entities.ULike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ULikeRepository extends JpaRepository<ULike, Integer> {
    List<ULike> findAllByPostId(int postId);
    List<ULike> findAllByCommentId(int commentId);
}
