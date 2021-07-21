package com.jiuxiniot.example.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {
    private Integer code = HttpStatus.INTERNAL_SERVER_ERROR.value();

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
