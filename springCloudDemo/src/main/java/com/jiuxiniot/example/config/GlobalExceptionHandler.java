package com.jiuxiniot.example.config;


import com.jiuxiniot.example.dto.ResponseEntity;
import com.jiuxiniot.example.entity.enums.ErrCode;
import com.jiuxiniot.example.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.format.DateTimeParseException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalStateException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity handlerParseDataException(IllegalStateException e) {
        log.error("data parse error: ", e);
        return ResponseEntity.fail(-1, "数据解析失败");
    }

    @ExceptionHandler({ApiException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity handleApiException(ApiException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity(
                e.getCode() != null ? e.getCode() : HttpStatus.INTERNAL_SERVER_ERROR.value(),
                e.getMessage()
        );
    }
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = bindingResult.getFieldError().getDefaultMessage();
        log.error(e.getMessage(), e);
        return new ResponseEntity(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                message
        );
    }
    @ExceptionHandler({DateTimeParseException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity handleDateTimeException(DateTimeParseException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity(
                ErrCode.DATA_TIME_FORMAT_ERROR.getErrCode(),
                ErrCode.DATA_TIME_FORMAT_ERROR.getMsg()
        );
    }
}
