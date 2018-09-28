package com.example.demo.common;

import org.springframework.http.HttpStatus;

/**
 * 创建时间 2018年九月28日 星期五 17:35
 * 作者: zhangjunping
 */
public class RestApiResponse<T> {
    private String errorInfo;

    private Integer code;

    private T data;

    public static RestApiResponse<String> fail(Integer code, String errorInfo) {
        RestApiResponse<String> response = new RestApiResponse<>();
        response.setCode(code);
        response.setErrorInfo(errorInfo);
        return response;
    }

    public static <T> RestApiResponse success(T data) {
        RestApiResponse response = new RestApiResponse();
        response.setCode(HttpStatus.OK.value());
        response.setData(data);
        return response;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
