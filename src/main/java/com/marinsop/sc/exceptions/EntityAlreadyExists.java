package com.marinsop.sc.exceptions;

public class EntityAlreadyExists extends RuntimeException{
    private String message;
    public EntityAlreadyExists() {}
    public EntityAlreadyExists(String msg){
        super(msg);
        this.message = msg;
    }
}
