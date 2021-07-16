package tech.chaosmin.framework.handler

import tech.chaosmin.framework.entity.OperateResult

/**
 * 基础操作接口 <p>
 * [Req] 请求参数类型
 * [Resp] 返回参数类型
 * @author Romani min
 * @since 2021/7/16 18:02
 */
interface Operate<Req, Resp> {
    fun operate(arg: Req): OperateResult<Resp>
}