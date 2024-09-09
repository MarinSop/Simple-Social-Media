package com.marinsop.sc.exceptions;

public class FriendshipAlreadyExists extends RuntimeException {
    private String message;
    public FriendshipAlreadyExists(){};
    public FriendshipAlreadyExists(String message) {

        super(message);
        this.message = message;
    }
}
