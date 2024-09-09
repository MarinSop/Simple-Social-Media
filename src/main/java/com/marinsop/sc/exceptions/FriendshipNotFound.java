package com.marinsop.sc.exceptions;

public class FriendshipNotFound extends RuntimeException {
    private String message;
    public FriendshipNotFound(){};
    public FriendshipNotFound(String message) {
        super(message);
        this.message = message;
    }
}
