package com.marcos.server.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.marcos.server.model.exception.BadRequestException;
import com.marcos.server.model.exception.NotFoundException;
import com.marcos.server.model.exception.StandardError;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<StandardError> badRequest(BadRequestException e, HttpServletRequest request){

        String message = e.getMessage();
        String error = "Bad Request Error";
        
        if(message == null) message = e.toString();

        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(error, status.value(), message, new Date());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError> notFound(NotFoundException e, HttpServletRequest request){

        String message = e.getMessage();
        String error = "Not Found Error";
        
        if(message == null) message = e.toString();

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(error, status.value(), message, new Date());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<StandardError> defaultNotFoundException(HttpServletRequest request) {
        String message = "Resource not found";
        String error = "Not Found";

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(error, status.value(), message, new Date());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
