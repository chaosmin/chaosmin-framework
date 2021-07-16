package tech.chaosmin.framework.enums

/**
 * 客户类型枚举 # 需同步RES_DATA <p>
 * @author Romani min
 * @since 2021/7/16 17:14
 */
enum class CustomerTypeEnum(private val code: Int, private val desc: String) : KeyValueEnum {
    PERSON(1, "个人用户"),
    COMPANY(2, "企业用户");

    override fun getCode(): Int = this.code
    override fun getDesc(): String = this.desc
}