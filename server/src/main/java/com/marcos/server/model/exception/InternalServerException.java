package com.marcos.server.model.exception;

public class InternalServerException extends RuntimeException{
    
    public InternalServerException(String message){
        super(message);
    }
}

