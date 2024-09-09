package com.marinsop.sc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "user_one_id", referencedColumnName = "id")
    private User userOne;
    @ManyToOne()
    @JoinColumn(name = "user_two_id", referencedColumnName = "id")
    private User userTwo;
}
