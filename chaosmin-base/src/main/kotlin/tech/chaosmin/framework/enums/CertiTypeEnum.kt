package tech.chaosmin.framework.enums

/**
 * 证件类型枚举 # 需同步RES_DATA <p>
 * @author Romani min
 * @since 2021/7/16 17:10
 */
enum class CertiTypeEnum(private val code: Int, private val desc: String) : KeyValueEnum {
    RESIDENT_IDENTITY_CARD(1, "身份证"),
    TEMPORARY_RESIDENT_IDENTITY_CARD(2, "临时身份证"),
    HOUSEHOLD_REGISTER(3, "户口簿"),
    OFFICER_ID(4, "军官证"),
    STUDENT_CARD(5, "学生证"),
    DRIVING_LICENSE(6, "驾驶证"),
    PASSPORT(7, "护照"),
    FOREIGNER_TRAVEL_PERMIT(8, "外国人旅行证"),
    MAINLAND_TRAVEL_PERMIT_FOR_TAIWAN_RESIDENTS(9, "台湾居民来往大陆通行证"),
    PASS_TO_AND_FROM_HONG_KONG_AND_MACAU(10, "往来港澳通行证"),
    PASS_TO_HONG_KONG_AND_MACAU(11, "前往港澳通行证"),
    TRAVEL_PERMIT_FOR_MAINLAND_RESIDENTS_IN_TAIWAN(12, "大陆居民往来台湾通行证"),
    FOREIGNER_RESIDENCE_PERMIT(13, "外国人居留证"),
    ORGANIZATION_CODE_CERTIFICATE(14, "组织机构代码证"),
    TAX_REGISTRATION_CERTIFICATE(15, "税务登记证"),
    BUSINESS_LICENSE(16, "营业执照"),
    UNIFIED_SOCIAL_CREDIT_CODE(17, "统一社会信用代码"),
    UNKNOWN_PERSONAL_ID(18, "未知个人证件"),
    VALID_CERTIFICATES_OF_OTHER_COMPANIES(19, "其他企业有效证件"),
    UNKNOWN_COMPANY_CERTIFICATE(20, "未知企业证件");

    override fun getCode(): Int = this.code
    override fun getDesc(): String = this.desc
}