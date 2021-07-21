package com.jiuxiniot.example.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 组织表
 * </p>
 *
 * @author wangxufei
 * @since 2018-06-15
 */
@Data
@TableName("uc_org")
public class Org extends Model<Org> {

    private static final long serialVersionUID = 1873L;

    /**
     * 主键id
     */
    private String id;
    /**
     * 排序
     */
    private Integer seq;
    /**
     * 父组织id
     */
    private String pid;
    /**
     * 父组织ids
     */
    private String pids;
    /**
     * 简称
     */
    private String simpleName;
    /**
     * 全称
     */
    private String fullName;
    /**
     * 提示
     */
    private String tips;
    /**
     * 状态(1：有效 2：无效 3：删除）
     */
    private Integer actived;
    /**
     * 版本
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
