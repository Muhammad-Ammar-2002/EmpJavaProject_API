package com.example.emp.Exceptions;

public class CustomeException extends  RuntimeException{
    private  String message;
    public CustomeException(String message) {
        super(message);
        this.message = message;

    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
