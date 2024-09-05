package com.marinsop.sc.repositories;

import com.marinsop.sc.entities.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendshipRepository extends JpaRepository<Friendship, Integer> {
}
