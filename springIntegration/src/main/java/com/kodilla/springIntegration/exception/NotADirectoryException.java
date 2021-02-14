package com.kodilla.springIntegration.exception;

public class NotADirectoryException extends RuntimeException {
    public NotADirectoryException(String errorMessage){
        super(errorMessage);
    }

}
