package com.marinsop.sc.controllers;

import com.marinsop.sc.dtos.MessageDTO;
import com.marinsop.sc.entities.Message;
import com.marinsop.sc.entities.User;
import com.marinsop.sc.services.MessageService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/messages")
@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping()
    public ResponseEntity<Message> sendMessage(@AuthenticationPrincipal User user, @RequestBody MessageDTO message)
    {
        return ResponseEntity.ok(messageService.sendMessage(user, message));
    }

    @PutMapping()
    public ResponseEntity<Message> editMessage(@AuthenticationPrincipal User user, @RequestBody MessageDTO message)
    {
        return ResponseEntity.ok(messageService.editMessage(user, message));
    }

    @DeleteMapping("{messageId}")
    public ResponseEntity<Message> deleteMessage(@AuthenticationPrincipal User user,@PathVariable("messageId") int messageId)
    {
        return ResponseEntity.ok(messageService.deleteMessage(user,messageId));
    }
}
