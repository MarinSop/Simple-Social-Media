package com.marinsop.sc.exceptions;

public class InvalidTarget extends RuntimeException {
    private String message;
    public InvalidTarget(){};
    public InvalidTarget(String message) {

        super(message);
        this.message = message;
    }
}
