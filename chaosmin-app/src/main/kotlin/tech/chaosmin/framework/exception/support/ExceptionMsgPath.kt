package tech.chaosmin.framework.exception.support

/**
 * 异常消息系统定义 资源路径
 * @author Romani min
 * @since 2021/7/16 18:29
 */
enum class ExceptionMsgPath(val code: Array<String>, val path: Array<String>) {
    FRM_EXCEPTION_MSG(
        arrayOf("frm_exception_msg", "app_exception_msg"),
        arrayOf("META-INF/errors_framework_zh.properties", "META-INF/errors_app_zh.properties")
    );

    override fun toString(): String {
        return code.indices.joinToString(",") { i -> "${name[i]}:${path[i]}" }
    }
}