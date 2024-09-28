package com.antony.projetousuario.handler;

import com.antony.projetousuario.exceptions.ObjectsException;
import com.antony.projetousuario.model.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectsException.class)
    public ResponseEntity<StandardError> objectError(ObjectsException object, ServletRequest request){
        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), System.currentTimeMillis(), object.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
