package tech.chaosmin.framework.enums

/**
 * 状态枚举 <p>
 * @author Romani min
 * @since 2021/7/16 17:18
 */
enum class StatusEnum(private val code: Int, private val desc: String) : KeyValueEnum {
    DISABLED(0, "不可用"),
    ENABLED(1, "可用");

    override fun getCode(): Int = this.code
    override fun getDesc(): String = this.desc
}