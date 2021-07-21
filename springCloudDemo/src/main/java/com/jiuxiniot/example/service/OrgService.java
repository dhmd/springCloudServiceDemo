package com.jiuxiniot.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiuxiniot.example.entity.Org;

public interface OrgService extends IService<Org> {

    Boolean isHaveUser(String orgId); //组织是否存在用户
}
