package com.jiuxiniot.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jiuxiniot.example.entity.enums.ErrCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class ResponseEntity<T> {
    /**
     * 状态码
     */
    private int code;

    /**
     * 状态码
     */
    private int errCode;

    /**
     * 时间戳
     */
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date timestamp;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 响应数据
     */
    private T data;

    public ResponseEntity(String msg) {
        this.code = ErrCode.SUCCESS.getErrCode();
        this.errCode = ErrCode.OK.getErrCode();
        this.msg = msg;
        this.timestamp = new Date();
    }

    public ResponseEntity(String msg, T data) {
        this.code = ErrCode.SUCCESS.getErrCode();
        this.errCode = ErrCode.OK.getErrCode();
        this.msg = msg;
        this.data = data;
        this.timestamp = new Date();
    }

    public ResponseEntity(T data) {
        this.code = ErrCode.SUCCESS.getErrCode();
        this.errCode = ErrCode.OK.getErrCode();
        this.msg = ErrCode.OK.getMsg();
        this.data = data;
        this.timestamp = new Date();
    }

    public ResponseEntity(int errCode, String msg) {
        this.code = errCode;
        this.errCode = errCode;
        this.msg = msg;
        this.timestamp = new Date();
    }

    public ResponseEntity(int errCode, String msg, T data) {
        this.code = errCode;
        this.errCode = errCode;
        this.msg = msg;
        this.timestamp = new Date();
        this.data = data;
    }

    public static ResponseEntity ok(Object data) {
        return new ResponseEntity(data);
    }

    public static ResponseEntity ok() {
        return new ResponseEntity("操作成功");
    }

    public static ResponseEntity fail(int errCode, String msg) {
        return new ResponseEntity(errCode, msg);
    }
}
