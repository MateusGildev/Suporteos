package com.curso.Suporteos.controller.exceptions;



import java.util.ArrayList;

import java.util.List;

public class ValidationError extends StandardError {

    List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(){
        super();
    }

    public ValidationError(Long timeStamp, Integer status, String error, String message, String path) {
        super(timeStamp, status, error, message, path);

    }



    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addErrors(String message, String fieldMessage){
        this.errors.add(new FieldMessage(fieldMessage, message));
    }
}
