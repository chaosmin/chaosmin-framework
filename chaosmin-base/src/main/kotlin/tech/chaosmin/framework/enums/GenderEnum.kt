package tech.chaosmin.framework.enums

/**
 * 性别枚举 # 需同步RES_DATA <p>
 * @author Romani min
 * @since 2021/7/16 17:06
 */
enum class GenderEnum(private val code: Int, private val desc: String) : KeyValueEnum {
    UNKNOWN(0, "未知"),
    MALE(1, "男"),
    FEMALE(2, "女"),
    NOT_STATED(3, "未说明");

    override fun getCode(): Int = this.code
    override fun getDesc(): String = this.desc
}