package com.marinsop.sc.repositories;

import com.marinsop.sc.entities.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FriendshipRepository extends JpaRepository<Friendship, Integer> {
    @Query("SELECT f FROM Friendship f WHERE (f.userOne.id = ?1 AND f.userTwo.id = ?2) OR (f.userOne.id = ?2 and f.userTwo.id = ?1)")
    Optional<Friendship> findByUsersId(int userOneId, int userTwoId);

    @Query("SELECT f FROM Friendship f WHERE f.userOne.id = ?1 OR f.userTwo.id = ?1")
    List<Friendship> findAllUsersFriends(int userId);
}
