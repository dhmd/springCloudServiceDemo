package com.jiuxiniot.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiuxiniot.example.dto.mapper.OrgMapper;
import com.jiuxiniot.example.entity.User;
import com.jiuxiniot.example.entity.Org;
import com.jiuxiniot.example.service.OrgService;
import com.jiuxiniot.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @classname: OrgServiceImpl
 * @description:
 * @author: dhm
 * @create: 2021/07/21 14:17
 */
@Service
public class OrgServiceImpl extends ServiceImpl<OrgMapper, Org> implements OrgService {

    @Autowired
    private UserService userService;

    @Override
    public Boolean isHaveUser(String orgId) {
        User user = userService.getOne(new QueryWrapper<User>().eq("org_id",orgId));
        if (user==null){
            return false;
        }
        return true;
    }
}
