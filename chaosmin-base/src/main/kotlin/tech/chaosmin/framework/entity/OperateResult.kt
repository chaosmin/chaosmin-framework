package tech.chaosmin.framework.entity

import java.io.Serializable

/**
 * 操作方法执行结果 <p>
 * @author Romani min
 * @since 2021/7/16 18:04
 */
data class OperateResult<T>(
    var code: String,
    var msg: String? = null,
    var data: T? = null,
    var success: Boolean = true
) : Serializable