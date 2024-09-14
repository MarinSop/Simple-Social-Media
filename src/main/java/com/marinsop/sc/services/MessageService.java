package com.marinsop.sc.services;

import com.marinsop.sc.dtos.MessageDTO;
import com.marinsop.sc.entities.Message;
import com.marinsop.sc.entities.User;
import com.marinsop.sc.exceptions.EntityNotFound;
import com.marinsop.sc.exceptions.InvalidTarget;
import com.marinsop.sc.repositories.MessageRepository;
import com.marinsop.sc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;

    public Message sendMessage(User user, MessageDTO sentMessage)
    {
        User receiver = userRepository.findById(sentMessage.getReceiverId()).orElseThrow(() -> new EntityNotFound("Receiver not found."));
        Message newMessage = new Message();
        newMessage.setSender(user);
        newMessage.setReceiver(receiver);
        newMessage.setContent(sentMessage.getContent());
        return messageRepository.save(newMessage);
    }

    public Message editMessage(User user, MessageDTO newMessage)
    {
        Message oldMessage = messageRepository.findById(newMessage.getId()).orElseThrow(() -> new EntityNotFound("Message not found."));
        if(user.getId() != oldMessage.getId())
        {
            throw new InvalidTarget("Invalid target.");
        }
        oldMessage.setContent(newMessage.getContent());
        return messageRepository.save(oldMessage);
    }

    public Message deleteMessage(User user, int messageId)
    {
        Message message = messageRepository.findById(messageId).orElseThrow(() -> new EntityNotFound("Message not found."));
        if(user.getId() != message.getSender().getId())
        {
            throw new InvalidTarget("Invalid target.");
        }
        messageRepository.delete(message);
        return message;
    }
}
