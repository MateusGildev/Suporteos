package com.curso.Suporteos.Services.exceptions;

public class ObjectNotFoundException extends RuntimeException{

    private static final Long serialVersionUID = 1L;
    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
