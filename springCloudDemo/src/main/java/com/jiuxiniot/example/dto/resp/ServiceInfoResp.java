package com.jiuxiniot.example.dto.resp;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * @classname: ServiceInfoReq
 * @description:
 * @author: dhm
 * @create: 2021/07/14 13:55
 */
@Data
public class ServiceInfoResp {

    private static final long serialVersionUID = 1L;

    private String name;

    private LocalDateTime dateTime;

}
