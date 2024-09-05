package com.marinsop.sc.controllers;

import com.marinsop.sc.services.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FriendshipController {
    @Autowired
    private FriendshipService friendshipService;
}
