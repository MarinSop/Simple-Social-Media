package com.marinsop.sc.controllers;

import com.marinsop.sc.entities.Friendship;
import com.marinsop.sc.entities.User;
import com.marinsop.sc.services.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/friendships")
@RestController
public class FriendshipController {
    @Autowired
    private FriendshipService friendshipService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Friendship>> findAllUsersFriends(@PathVariable("userId") int userId)
    {
        return ResponseEntity.ok(friendshipService.findAllUsersFriends(userId));
    }

    @PostMapping("/{userTwoId}")
    public ResponseEntity<Friendship> addFriend(@AuthenticationPrincipal User userOne, @PathVariable("userTwoId") int userTwoId)
    {
        return ResponseEntity.ok(friendshipService.addFriend(userOne,userTwoId));
    }

    @DeleteMapping("/{userTwoId}")
    public ResponseEntity<Friendship> deleteFriend(@AuthenticationPrincipal User userOne, @PathVariable("userTwoId") int userTwoId)
    {
        return ResponseEntity.ok(friendshipService.deleteFriend(userOne,userTwoId));
    }
}
