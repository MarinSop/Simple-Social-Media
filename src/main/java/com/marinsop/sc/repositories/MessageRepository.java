package com.marinsop.sc.repositories;

import com.marinsop.sc.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
