package com.example.demo.exception;

public abstract class ProjectException extends RuntimeException {

    private String errorInfo;

    public String getErrorInfo() {
        return errorInfo;
    }

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public ProjectException(String errorInfo) {
        super(errorInfo);
        this.errorInfo = errorInfo;
    }

    @Override
    public String getMessage() {
        return errorInfo;
    }
}
