package com.marinsop.sc.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String bio;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Post> posts = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "sender")
    private Set<Message> sentMessages = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "receiver")
    private Set<Message> receivedMessages = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Comment> comments = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "userOne")
    private Set<Friendship> friendshipsOne = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "userTwo")
    private Set<Friendship> friendshipsTwo = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<ULike> ULikes = new HashSet<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }


}
