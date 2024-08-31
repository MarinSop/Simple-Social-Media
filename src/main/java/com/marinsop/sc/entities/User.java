package com.marinsop.sc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String bio;

    @OneToMany(mappedBy = "user")
    private Set<Post> posts = new HashSet<>();

    @OneToMany(mappedBy = "sender")
    private Set<Message> sentMessages = new HashSet<>();
    @OneToMany(mappedBy = "receiver")
    private Set<Message> receivedMessages = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "userOne")
    private Set<Friendship> friendshipsOne = new HashSet<>();
    @OneToMany(mappedBy = "userTwo")
    private Set<Friendship> friendshipsTwo = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<ULike> ULikes = new HashSet<>();


}
