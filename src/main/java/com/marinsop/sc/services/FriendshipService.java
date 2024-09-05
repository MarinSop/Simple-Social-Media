package com.marinsop.sc.services;

import com.marinsop.sc.repositories.FriendshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendshipService {
    @Autowired
    private FriendshipRepository friendshipRepository;
}
