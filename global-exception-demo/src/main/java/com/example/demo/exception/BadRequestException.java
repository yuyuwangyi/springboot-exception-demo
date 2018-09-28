package com.example.demo.exception;

/**
 * 自定义异常
 */
public class BadRequestException extends ProjectException {
    private final String operationName;
    private final String message;

    public BadRequestException(String operationName, String message) {
        super(operationName + ": " + message);
        this.operationName = operationName;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getOperationName() {
        return operationName;
    }
}
