package com.jiuxiniot.example.dto.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @classname: ServiceInfo
 * @description:
 * @author: dhm
 * @create: 2021/07/14 13:55
 */
@Data
public class ServiceInfo {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "name不能为null")
    @ApiModelProperty(value="名字", required=true)
    private String name;

    @ApiModelProperty(value="时间")
    private LocalDateTime dateTime;

}
