package com.jiuxiniot.example.controller;

import com.jiuxiniot.example.dto.ResponseEntity;
import com.jiuxiniot.example.dto.req.ServiceInfo;
import com.jiuxiniot.example.entity.InfoEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @classname: ServiceController
 * @description:
 * @author: dhm
 * @create: 2021/07/14 13:52
 */

@RestController
@RequestMapping("/service")
@Api(value = "ServiceController", tags = {"ServiceController模块"})
public class ServiceController {

    @PostMapping("/hello")
    @ApiOperation("获取密码1")
    @ResponseBody
    public String login(@RequestBody @Validated ServiceInfo serviceInfo) {
        return "Service1:Welcome " + serviceInfo.getName() + " !";
    }

    @PostMapping("/rest")
    @ApiOperation("获取密码2")
    @ResponseBody
    public InfoEntity rest(@RequestBody ServiceInfo serviceInfo){
        InfoEntity infoEntity = new InfoEntity();
        infoEntity.setAuth_code("1000");
        return infoEntity;
    }

}
