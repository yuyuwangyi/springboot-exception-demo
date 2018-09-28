package com.example.demo.config;

import com.example.demo.common.RestApiResponse;
import com.example.demo.exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;

/**
 * 创建时间 2018年九月28日 星期五 17:26
 * 作者: zhangjunping
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(HttpStatusCodeException.class)
    public ResponseEntity<String> handleStatusCodeException(HttpStatusCodeException ex) {
        logger.error("异常信息：{}", ex);
        return new ResponseEntity<>(ex.getResponseBodyAsString(), ex.getStatusCode());
    }

    // 400
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestApiResponse<String> handleBadRequestException(BadRequestException ex) {
        logger.error("操作模块：{}\n异常信息：{}", ex.getOperationName(), ex.getMessage());
        return RestApiResponse.fail(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    // 401
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public RestApiResponse<String> handleUnauthorizedException(UnauthorizedException ex) {
        logger.error("异常信息：{}", ex);
        return RestApiResponse.fail(HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
    }

    // 403
    @ExceptionHandler(OperationForbiddenException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ResponseBody
    public RestApiResponse<String> handleOperationForbiddenException(OperationForbiddenException ex) {
        logger.error("异常信息：{}", ex);
        return RestApiResponse.fail(HttpStatus.FORBIDDEN.value(), ex.getMessage());
    }

    // 404
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public RestApiResponse<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        logger.error("异常信息：{}", ex);
        return RestApiResponse.fail(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    // 409
    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ResponseBody
    public RestApiResponse<String> handleConflictException(ConflictException ex) {
        logger.error("异常信息：{}", ex);
        return RestApiResponse.fail(HttpStatus.CONFLICT.value(), ex.getMessage());
    }


}
