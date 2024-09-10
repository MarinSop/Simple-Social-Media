package com.marinsop.sc.exceptions;

public class PostNotFound extends RuntimeException {
    private String message;
    public PostNotFound(){};
    public PostNotFound(String message)
    {
        super(message);
        this.message = message;
    }
}
