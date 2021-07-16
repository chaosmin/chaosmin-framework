package tech.chaosmin.framework.enums

/**
 * 业务号码类型枚举 <p>
 * @author Romani min
 * @since 2021/7/16 17:12
 */
enum class BizNoTypeEnum(private val code: Int, private val desc: String) : KeyValueEnum {
    ;

    override fun getCode(): Int = this.code
    override fun getDesc(): String = this.desc
}