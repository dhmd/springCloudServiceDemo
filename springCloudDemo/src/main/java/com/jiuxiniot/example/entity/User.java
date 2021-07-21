package com.jiuxiniot.example.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author wangxufei
 * @since 2018-06-15
 */
@Data
@TableName("uc_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 14443443444387L;

    /**
     * 主键id
     */
    private String id;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * md5密码盐
     */
    private String salt;
    /**
     * 名字
     */
    private String name;
    /**
     * 生日
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date birthday;
    /**
     * 性别（1：男 2：女）
     */
    private Integer sex;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 电话
     */
    private String phone;
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 组织id
     */
    private String orgId; //    private String roleId; //@TableField(exist = false)
    /**
     * 组织id
     */
    @TableField(exist = false)
    private String orgName; //  @TableField(exist = false)
    
    /**
     * 岗位
     */
    private String quarters;
    /**
     * 状态(1：启用  2：冻结  3：删除）
     */
    private Integer actived;
    /**
     * 保留字段
     */
    private Integer version;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd'T'HH:mm:ss")//".SSSZZZZ"
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd'T'HH:mm:ss")//".SSSZZZZ"
    private Date updateTime;
    /**
     * 上次登录时间
     */
    private LocalDateTime lastLoginTime;
    /**
     * 上次登录地点
     */
    private String lastLoginLocation;

    /**
     * 支付密码
     */
    private String payPassword;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
