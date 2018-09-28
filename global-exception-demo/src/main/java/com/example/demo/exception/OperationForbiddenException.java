package com.example.demo.exception;


public class OperationForbiddenException extends ProjectException {

    public OperationForbiddenException() {
        super("无权限执行此操作");
    }
}
