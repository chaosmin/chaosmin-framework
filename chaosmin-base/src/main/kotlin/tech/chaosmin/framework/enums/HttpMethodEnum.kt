package tech.chaosmin.framework.enums

/**
 * HTTP请求方式枚举 <p>
 * @author Romani min
 * @since 2021/7/16 17:15
 */
enum class HttpMethodEnum(private val code: Int, private val desc: String) : KeyValueEnum {
    GET(1, "读取"),
    POST(2, "保存"),
    PUT(3, "更新"),
    DELETE(4, "删除");

    override fun getCode(): Int = this.code
    override fun getDesc(): String = this.desc
}