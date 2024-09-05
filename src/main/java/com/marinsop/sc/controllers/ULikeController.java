package com.marinsop.sc.controllers;

import com.marinsop.sc.services.ULikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ULikeController {
    @Autowired
    private ULikeService uLikeService;
}
