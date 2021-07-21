package com.jiuxiniot.example.dto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiuxiniot.example.entity.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * <p>
  * 管理员表 Mapper 接口
 * </p>
 *
 * @author wangxufei
 * @since 2018-06-15
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


}