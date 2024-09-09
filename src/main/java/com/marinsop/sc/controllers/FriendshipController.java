package com.marinsop.sc.controllers;

import com.marinsop.sc.entities.Friendship;
import com.marinsop.sc.services.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/add")
    public ResponseEntity<Friendship> addFriend(@RequestParam("userOneId") int userOneId, @RequestParam("userTwoId") int userTwoId)
    {
        return ResponseEntity.ok(friendshipService.add(userOneId,userTwoId));
    }

    @DeleteMapping("")
    public ResponseEntity<Friendship> deleteFriend(@RequestParam("userOneId") int userOneId, @RequestParam("userTwoId") int userTwoId)
    {
        return ResponseEntity.ok(friendshipService.deleteFriend(userOneId,userTwoId));
    }
}
