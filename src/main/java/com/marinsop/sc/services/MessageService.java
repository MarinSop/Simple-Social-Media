package com.marinsop.sc.services;

import com.marinsop.sc.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
}
