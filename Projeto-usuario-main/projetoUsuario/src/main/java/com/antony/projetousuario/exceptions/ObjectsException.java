package com.antony.projetousuario.exceptions;

public class ObjectsException extends RuntimeException{

    public ObjectsException(String message) {
        super(message);
    }

    public ObjectsException(String message, Throwable cause) {
        super(message, cause);
    }

}
