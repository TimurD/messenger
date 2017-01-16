package com.timur.java.exception;

/**
 * Created by timur_000 on 17.12.2016.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message){
        super(message);
    }
}
