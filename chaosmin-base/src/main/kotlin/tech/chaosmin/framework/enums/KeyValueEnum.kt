package tech.chaosmin.framework.enums

import java.io.Serializable

/**
 * 通用枚举实现接口
 * @author Romani min
 * @since 2021/7/16 17:07
 */
interface KeyValueEnum : Serializable {
    /**
     * 获取枚举编号
     * @return [Int] 数字编号
     */
    fun getCode(): Int

    /**
     * 获取枚举描述
     * @return [String] 枚举描述内容
     */
    fun getDesc(): String
}