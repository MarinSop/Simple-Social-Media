package com.marinsop.sc.exceptions;

public class CommentNotFound extends RuntimeException {
    private String message;
    public CommentNotFound(){};
    public CommentNotFound(String message) {

        super(message);
        this.message = message;
    }
}
