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

    public Friendship addFriend(User userOne,int userTwoId)
    {
        User userTwo = userRepository.findById(userTwoId).orElseThrow(() -> new EntityNotFound("User not found."));
        friendshipRepository.findByUsersId(userOne.getId(),userTwoId).ifPresent(f -> {throw new EntityAlreadyExists("Friendship already exists.");});
        Friendship friendship = new Friendship();
        friendship.setUserOne(userOne);
        friendship.setUserTwo(userTwo);
        return friendshipRepository.save(friendship);
    }

    public Friendship deleteFriend(User userOne, int userTwoId)
    {
        Friendship friendship = friendshipRepository.findByUsersId(userOne.getId(),userTwoId).orElseThrow(() -> new EntityNotFound("Friendship not found."));
        friendshipRepository.delete(friendship);
        return(friendship);
    }
}
