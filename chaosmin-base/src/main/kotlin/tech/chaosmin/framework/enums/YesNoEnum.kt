package tech.chaosmin.framework.enums

/**
 * 是否枚举 <p>
 * @author Romani min
 * @since 2021/7/16 17:19
 */
enum class YesNoEnum(private val code: Int, private val desc: String) : KeyValueEnum {
    NO(0, "否"),
    YES(1, "是");

    override fun getCode(): Int = this.code
    override fun getDesc(): String = this.desc
}