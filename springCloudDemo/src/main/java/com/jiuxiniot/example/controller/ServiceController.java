package com.jiuxiniot.example.controller;

import com.jiuxiniot.example.dto.req.ServiceInfoReq;
import com.jiuxiniot.example.entity.InfoEntity;
import com.jiuxiniot.example.entity.User;
import com.jiuxiniot.example.service.OrgService;
import com.jiuxiniot.example.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @Resource
    private UserService userService;

    @Resource
    private OrgService orgService;

    @PostMapping("/hello")
    @ApiOperation("获取密码1")
    @ResponseBody
    public String login(@RequestBody @Validated ServiceInfoReq serviceInfoReq) {
        return "Service1:Welcome " + serviceInfoReq.getName() + " !";
    }

    @PostMapping("/rest")
    @ApiOperation("获取密码2")
    @ResponseBody
    public InfoEntity rest(@RequestBody ServiceInfoReq serviceInfoReq){
        InfoEntity infoEntity = new InfoEntity();
        infoEntity.setAuth_code("1000");
        return infoEntity;
    }

    @ApiOperation("获取用户详细信息")
    @GetMapping("/getUseInfo")
    @ResponseBody
    public User getUseInfo(@RequestParam(name = "userId") String userId) {
        User user = userService.getById(userId);
        if (StringUtils.isBlank(user.getOrgId())) {
        } else {
            user.setOrgName(orgService.getById(user.getOrgId()).getSimpleName());
        }
        return user;
    }

}
