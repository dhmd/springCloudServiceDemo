package com.jiuxiniot.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiuxiniot.example.dto.mapper.UserMapper;
import com.jiuxiniot.example.entity.User;
import com.jiuxiniot.example.service.OrgService;
import com.jiuxiniot.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @classname: UserServiceImpl
 * @description:
 * @author: dhm
 * @create: 2021/07/21 14:27
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private OrgService orgService;

}
