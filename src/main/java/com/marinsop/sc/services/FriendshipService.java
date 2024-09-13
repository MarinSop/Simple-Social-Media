package com.marinsop.sc.services;

import com.marinsop.sc.entities.Friendship;
import com.marinsop.sc.entities.User;
import com.marinsop.sc.exceptions.EntityAlreadyExists;
import com.marinsop.sc.exceptions.EntityNotFound;
import com.marinsop.sc.repositories.FriendshipRepository;
import com.marinsop.sc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendshipService {
    @Autowired
    private FriendshipRepository friendshipRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Friendship> findAllUsersFriends(int userId)
    {
        return friendshipRepository.findAllUsersFriends(userId);
    }

    public Friendship add(int userOneId,int userTwoId)
    {
        User userOne = userRepository.findById(userOneId).orElseThrow(() -> new EntityNotFound("User not found."));
        User userTwo = userRepository.findById(userTwoId).orElseThrow(() -> new EntityNotFound("User not found."));
        friendshipRepository.findByUsersId(userOneId,userTwoId).ifPresent(f -> {throw new EntityAlreadyExists("Friendship already exists.");});
        Friendship friendship = new Friendship();
        friendship.setUserOne(userOne);
        friendship.setUserTwo(userTwo);
        return friendshipRepository.save(friendship);
    }

    public Friendship deleteFriend(int userOneId, int userTwoId)
    {
        Friendship friendship = friendshipRepository.findByUsersId(userOneId,userTwoId).orElseThrow(() -> new EntityNotFound("Friendship not found."));
        friendshipRepository.delete(friendship);
        return(friendship);
    }
}
