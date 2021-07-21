package com.jiuxiniot.example.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrCode {
    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),

    /**
     * 操作成功
     */
    OK(0, "操作成功"),

    DATA_UPDATED(400, "此数据已被修改，请刷新后重试"),

    INTERNAL_SERVER_ERROR(500, "Internal Server ErrorCount"),

    PARAM_VALID_FAIL(10100, "参数校验失败"),

    ACCOUNT_INVALID(10201, "账号已失效"),

    ACCOUNT_NOT_FOUND(10202, "抱歉，该用户不存在"),

    ACCOUNT_ERROR(10203, "您输入的密码错误"),

    EMPTY_PERMISSION(10204, "抱歉，账号没有权限，无法登录"),

    PASSWORD_ALWAYS_ERROR(10205, "密码连续输入3次错误"),

    TOKEN_EXPIRED(10303, "令牌已失效"),

    NO_PERMISSION_ERROR(10401, "没有访问该接口的权限"),

    ACCESS_ERROR(10402, "抱歉，不能访问其他客户的设备"),

    UPLOAD_FILE_EMPTY(10601, "请选择文件上传"),

    UPLOAD_NAME_EMPTY(10602, "文件名称为空"),

    UPLOAD_TYPE_REJECT(10603, "您上传的文件格式不被允许"),

    UPLOAD_FILE_FAIL(10604, "文件上传失败"),

    FILE_ALREADY_EXISTS(10605, "上传失败，文件已存在"),

    VERSION_IS_OLD(10606, "上传失败，该版本太老"),

    VERSION_ALREADY_EXISTS(10607, "上传失败，该版本已存在"),

    FILE_TOO_LARGE(10608, "文件过大"),

    MACHINE_NOT_FOUND(10701, "该设备不存在"),

    POINT_NOT_FOUND(10801, "该检测点不存在"),

    JOB_NOT_FOUND(10901, "该工单不存在"),

    JOB_DELETE_ERROR(10902, "无法删除他人的工单"),

    JOB_IS_STARTED(10903, "工单已启动，无法删除"),

    CUSTOMER_NOT_FOUND(11001, "抱歉，该客户不存在"),

    PARAM_NOT_SET(12001, "请设置consul键值对"),

    THREE_PARTY(13001, "调用第三方接口错误"),

    MOCK_ERROR(14001, "MOCK数据出错"),

    REQUEST_SMS_ERROR(15001, "调用短信端口发生错误"),

    MAP_CONFIG_NOT_FOUND(16001, "设备地图配置不存在"),

    WORK_MACHINE_EXIST(17001, "该设备已作业，请选择未作业的设备"),
    WORK_NOT_EXIST(17002, "该作业不存在"),
    WORK_USER_HAS_WRITE(17003, "今天该班次本人已填写作业"),

    PUSH_NO_MSG(18001, "没有告警信息可以推送"),
    PUSH_ALIAS_NOT_FOUND(18002, "推送的别名不存在"),
    PUSH_FAILED(18003, "推送失败"),
    PUSH_NO_CONFIG(18004, "项目的推送配置不存在，请在consul中进行设置"),
    DATA_TIME_FORMAT_ERROR(18004, "时间格式错误");
    /**
     * 错误码
     */
    private int errCode;

    /**
     * 信息
     */
    private String msg;
}
