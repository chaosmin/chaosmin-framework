package tech.chaosmin.framework.entity

import tech.chaosmin.framework.enums.ErrorCodeEnum
import tech.chaosmin.framework.exception.FrameworkException
import java.io.Serializable

/**
 * @author Romani min
 * @since 2021/8/10 23:58
 */
data class RestResult<T>(
    var code: String,
    var msg: String? = null,
    var data: T? = null,
    var meta: Any = "",
    var success: Boolean = true
) : Serializable {
    fun mapper(result: OperateResult<T>): RestResult<T> = this.apply {
        this.success = result.success
        this.code = result.code
        this.msg = result.msg
        this.data = result.data
    }

    fun mapper(result: RestResult<*>): RestResult<T> = this.apply {
        this.success = result.success
        this.code = result.code
        this.msg = result.msg
    }

    fun take(data: T): RestResult<T> = this.apply {
        this.data = data
    }

    fun success(data: T? = null): RestResult<T> = this.apply {
        this.success = true
        this.data = data
    }

    fun convert(function: () -> T): RestResult<T> = this.apply {
        this.data = function()
    }
}

object RestResultExt {
    fun <T> failureRestResult(msg: String?) = RestResult<T>(ErrorCodeEnum.FAILURE.code, msg)
    fun failureRestResult(e: FrameworkException) = RestResult<String>(e.errCode ?: ErrorCodeEnum.FAILURE.code, e.getMsg())
}