package tech.chaosmin.framework.enums

enum class ResultCodeEnum(val code: String, val msg: String) {
    SUCCESS("SUCCESS", "请求成功"),

    // 系统异常返回码
    FAILURE("SYS_00001", "系统异常"),
    REQUEST_LIMITED("API_00001", "服务器请求达到上限"),
    FILE_DOWNLOAD_ERROR("IO_00001", "文件读取异常"),
    FILE_UPLOAD_ERROR("IO_00002", "文件保存异常"),
    RPC_ERROR("RPC_00001", "远程调用异常"),

    // 接口请求异常返回码
    NOT_SUPPORTED_FUNCTION("REQ_00001", "不支持的请求方式"),
    NOT_SUPPORTED_PARAM_TYPE("REQ_00002", "不支持的参数类型"),
    PARAM_IS_NULL("PARAMS_00001", "参数不能为空"),
    PARAM_IS_INVALID("PARAMS_00002", "参数不合法"),
    PARAM_LACK_DATA("PARAMS_00003", "缺少参数"),
    PARAM_OUT_OF_RANGE("PARAMS_00004", "参数超出可选范围"),

    // 用户登录类异常返回码
    NO_TOKEN("LOGIN_00001", "未获取到Token"),
    TOKEN_INVALID("LOGIN_00002", "Token不合法"),
    TOKEN_EXPIRED("LOGIN_00003", "Token已过期"),
    USER_NOT_FOUND("LOGIN_10001", "未找到指定用户"),
    AUTHENTICATION_FAILED("LOGIN_10002", "登录失败"),
    NO_PERMISSION("PERMISSION_00001", "权限不足"),

    // 业务常见异常返回码
    BUSINESS_ERROR("BIZ_00001", "业务异常"),
    DATA_ERROR("BIZ_00002", "数据异常"),
    STATUS_ERROR("BIZ_00003", "状态异常"),

    // 资源异常返回码
    RESOURCE_NOT_EXIST("RESOURCE_00001", "资源不存在"),
    RESOURCE_EXISTED("RESOURCE_00002", "资源已存在"),
    RESOURCE_INVALID("RESOURCE_00003", "资源不合法");
}