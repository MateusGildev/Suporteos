package com.curso.Suporteos.controller.exceptions;

public class FieldMessage {
    private String message;
    private String fieldMessage;

    public FieldMessage(){
        super();
    }

    public FieldMessage(String fieldMessage, String message) {
        this.fieldMessage = fieldMessage;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFieldMessage() {
        return fieldMessage;
    }

    public void setFieldMessage(String fieldMessage) {
        this.fieldMessage = fieldMessage;
    }
}
