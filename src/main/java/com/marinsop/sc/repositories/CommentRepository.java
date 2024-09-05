package com.marinsop.sc.repositories;

import com.marinsop.sc.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
