package com.springboot.assignment3.model;

public class ExceptionDTO extends RuntimeException{

    public ExceptionDTO(String message) {
        super(message);
    }

    public ExceptionDTO(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionDTO(Throwable cause) {
        super(cause);
    }
}
