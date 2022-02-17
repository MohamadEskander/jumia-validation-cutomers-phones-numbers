package com.example.jumiatask.rest.exceptionHandler;

public class NoDataFoundException extends RuntimeException{
    public NoDataFoundException(String message) {
        super(message);
    }
}
