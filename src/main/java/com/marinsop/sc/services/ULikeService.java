package com.marinsop.sc.services;

import com.marinsop.sc.repositories.ULikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ULikeService {
    @Autowired
    private ULikeRepository uLikeRepository;
}
