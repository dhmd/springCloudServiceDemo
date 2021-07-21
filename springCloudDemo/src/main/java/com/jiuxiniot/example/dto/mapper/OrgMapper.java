package com.jiuxiniot.example.dto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.jiuxiniot.example.entity.User;
import com.jiuxiniot.example.entity.Org;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 组织表 Mapper 接口
 * </p>
 *
 * @author wangxufei
 * @since 2018-06-15
 */
@Mapper
public interface OrgMapper extends BaseMapper<Org> {

    /**
     * 获取所有部门列表
     */
    List<Map<String, Object>> list(@Param("condition") String condition);

    
    /**
     * 获取组织下的用户
     */
    List<User> selectUserByOrgId(@Param("orgId") String orgId);
}