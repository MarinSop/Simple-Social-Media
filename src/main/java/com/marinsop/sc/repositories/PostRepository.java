package com.marinsop.sc.repositories;

import com.marinsop.sc.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findAllByUserId(int userId);
}
