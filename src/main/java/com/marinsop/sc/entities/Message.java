package com.marinsop.sc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_id",referencedColumnName = "id")
    private User sender;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receiver_id",referencedColumnName = "id")
    private User receiver;
}
