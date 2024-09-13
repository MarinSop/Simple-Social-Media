package com.marinsop.sc.exceptions;

public class EntityNotFound extends RuntimeException {
    private String message;
    public EntityNotFound(){};
    public EntityNotFound(String message) {
        super(message);
        this.message = message;
    }
}
