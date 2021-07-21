package com.jiuxiniot.example.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class InfoEntity {

    private String auth_code;

    private LocalDateTime date_time;

    private String sign;
}
