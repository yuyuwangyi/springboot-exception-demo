package com.example.demo.exception;


public class UnauthorizedException extends ProjectException {

    public UnauthorizedException(String errorInfo) {
        super(errorInfo);
    }

}
