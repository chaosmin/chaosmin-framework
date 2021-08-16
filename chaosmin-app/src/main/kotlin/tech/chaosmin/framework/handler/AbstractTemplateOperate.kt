package tech.chaosmin.framework.handler

import cn.hutool.core.date.StopWatch
import org.slf4j.LoggerFactory
import tech.chaosmin.framework.entity.OperateResult
import tech.chaosmin.framework.exception.FrameworkException
import tech.chaosmin.framework.utils.JsonUtil
import java.io.Serializable

/**
 * 基础操作抽象类 <p>
 *
 * @author Romani min
 * @since 2021/7/16 17:25
 */
abstract class AbstractTemplateOperate<Req, Resp> : Serializable, Operate<Req, Resp> {
    private val logger = LoggerFactory.getLogger(AbstractTemplateOperate::class.java)

    /**
     * 前置 数据验证方法 <p>
     *     出现数据校验失败时, 直接抛出异常, 交给异常处理器进行处理
     * @param arg [Req] 操作入参
     */
    protected open fun validation(arg: Req) {}

    /**
     * 基础操作实际执行逻辑实现 <p>
     * @param arg [Req] 操作入参
     * @param result [OperateResult]<[Resp]> 链式操作结果入参
     * @return [OperateResult]<[Resp]> 操作执行结果
     */
    protected abstract fun processor(arg: Req, result: OperateResult<Resp>): OperateResult<Resp>

    /**
     * 后置 处理操作执行结果 <p>
     *     当需要对执行的结果做补充处理时, 重写该方法
     * @param arg [Req] 操作入参
     * @param result [OperateResult]<[Resp]> 操作执行结果
     */
    protected open fun result(arg: Req, result: OperateResult<Resp>) {}

    /**
     * 异常处理逻辑 <p>
     *     当出现异常时, 将异常信息写入方法
     * @param arg [Req] 操作入参
     * @param result [OperateResult]<[Resp]> 操作执行结果
     * @param exception [Exception] 逻辑执行时抛出的异常
     */
    protected open fun exceptionDetail(arg: Req, result: OperateResult<Resp>, exception: Exception) {
        if (result.msg?.isBlank() != false) {
            // 当错误秒系为空时, 填充当前执行错误的处理器的名称
            result.msg = "${this.javaClass.simpleName} handler exception"
        }
        // 如果出现的异常为FrameworkException, 则抛出的操作结果以异常信息为主
        if (exception is FrameworkException) {
            if (exception.errCode != null) {
                result.code = exception.errCode!!
            }
            if (exception.message != null) {
                result.msg = exception.message!!
            }
        }
        result.success = false
    }

    /**
     * 基础操作抽象类方法入口 <p>
     * @param arg [Req] 操作入参
     */
    override fun operate(arg: Req): OperateResult<Resp> {
        val handlerName = this.javaClass.simpleName
        var res: OperateResult<Resp> = OperateResult(code = "")
        val stopWatch = StopWatch(handlerName)
        try {
            // 验证
            stopWatch.start("[Validation]")
            validation(arg)
            stopWatch.stop()
            if (!res.success) {
                return res
            }

            // 业务处理
            stopWatch.start("[Processor]")
            res = processor(arg, res)
            stopWatch.stop()
            if (!res.success) {
                return res
            }

            // 执行后的操作
            stopWatch.start("[Result]")
            result(arg, res)
            stopWatch.stop()

        } catch (e: FrameworkException) {
            exceptionDetail(arg, res, e)
            // 可预见的系统框架级异常不再打印堆栈信息
            logger.error("process $handlerName framework exception, params: ${JsonUtil.encode(arg)}")
        } catch (e: Exception) {
            exceptionDetail(arg, res, e)
            logger.error("process $handlerName exception, params: ${JsonUtil.encode(arg)}", e)
        } finally {
            // TODO 将该监控打印调整为可配置功能
            logger.info(stopWatch.toString())
        }
        return res
    }
}