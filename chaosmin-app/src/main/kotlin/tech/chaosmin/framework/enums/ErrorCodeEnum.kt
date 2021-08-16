/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package tech.chaosmin.framework.enums

/**
 * @author Romani min
 * @since 2021/8/11 00:04
 */
enum class ErrorCodeEnum(val code: String, val msg: String) {
    SUCCESS("SUCCESS", "请求成功"),

    TOKEN_IS_EMPTY("TOKEN_00000", "未获取到Token"),
    TOKEN_INVALID("TOKEN_00001", "Token不合法"),
    TOKEN_EXPIRED("TOKEN_00002", "Token已过期"),

    NO_PERMISSION("PERMISSION_00001", "权限不足"),

    REQUEST_LIMITED("API_00001", "服务器请求达到上限"),

    BUSINESS_ERROR("BIZ_00001", "业务异常"),
    DATA_ERROR("BIZ_00002", "数据异常"),
    STATUS_ERROR("BIZ_00003", "状态异常"),

    FAILURE("SYS_00001", "请求失败"),
    NOT_SUPPORTED_FUNCTION("SYS_00002", "不支持的请求方式"),
    NOT_SUPPORTED_PARAM_TYPE("SYS_00003", "不支持的参数类型"),

    USER_NOT_FOUND("SYS_10001", "未找到指定用户"),
    AUTHENTICATION_FAILED("SYS_10002", "登录失败"),

    RESOURCE_NOT_EXIST("SYS_20001", "资源不存在"),
    RESOURCE_EXISTED("SYS_20002", "资源已存在"),
    RESOURCE_INVALID("SYS_20003", "资源不合法"),

    PARAM_IS_NULL("PARAMS_00001", "参数不能为空"),
    PARAM_IS_INVALID("PARAMS_00002", "参数不合法"),
    PARAM_LACK_DATA("PARAMS_00003", "数据缺失"),
    PARAM_OUT_OF_RANGE("PARAMS_00004", "数据不足")
}