package com.example.demo.exception;

/**
 * 请求资源不存在
 */
public class ResourceNotFoundException extends ProjectException {

    public ResourceNotFoundException() {
        super("找不到相应资源");
    }
}
