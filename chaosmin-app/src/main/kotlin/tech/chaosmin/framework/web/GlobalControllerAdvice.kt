package tech.chaosmin.framework.web

import org.slf4j.LoggerFactory
import org.springframework.core.annotation.Order
import org.springframework.http.converter.HttpMessageConversionException
import org.springframework.validation.BindException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.NoHandlerFoundException
import tech.chaosmin.framework.entity.RestResult
import tech.chaosmin.framework.entity.RestResultExt.failureRestResult
import tech.chaosmin.framework.exception.FrameworkException

/**
 * @author Romani min
 * @since 2021/8/10 23:55
 */
@Order(1)
@RestControllerAdvice
class GlobalControllerAdvice {
    private val logger = LoggerFactory.getLogger(GlobalControllerAdvice::class.java)

    /**
     * 404异常
     */
    @ExceptionHandler(NoHandlerFoundException::class)
    fun handleNoHandlerFoundException(e: NoHandlerFoundException): RestResult<String> {
        logger.error("捕获到NoHandlerFoundException", e)
        val message = "API: ${e.requestURL} url not found"
        return failureRestResult(msg = message)
    }

    /**
     * Method Not Supported
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    fun handleHttpRequestMethodNotSupportedException(e: HttpRequestMethodNotSupportedException): RestResult<String> {
        logger.error("捕获到HttpRequestMethodNotSupportedException", e)
        return failureRestResult(msg = e.message ?: "http method not supported")
    }

    /**
     * 请求参数异常
     */
    @ExceptionHandler(HttpMessageConversionException::class)
    fun handleHttpMessageConversionException(e: HttpMessageConversionException): RestResult<String> {
        logger.error("捕获到请求参数异常", e)
        return failureRestResult(msg = e.message ?: "invalid parameters")
    }

    /**
     * 请求参数缺失
     */
    @ExceptionHandler(MissingServletRequestParameterException::class)
    fun handleMissingServletRequestParameterException(e: MissingServletRequestParameterException): RestResult<String> {
        logger.error("捕获到请求参数缺失异常", e)
        return failureRestResult(msg = e.message)
    }

    /**
     * 参数校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException): RestResult<String> {
        val message = e.bindingResult.allErrors.joinToString { "${it.defaultMessage};" }
        logger.error("捕获到参数校验异常: {}", message, e)
        return failureRestResult(msg = message)
    }

    /**
     * 参数绑定异常
     */
    @ExceptionHandler(BindException::class)
    fun handleBindException(e: BindException): RestResult<String> {
        val message = e.bindingResult.allErrors.joinToString { "${it.defaultMessage};" }
        logger.error("捕获到参数绑定异常: {}", message, e)
        return failureRestResult(msg = message)
    }


    /**
     * 框架异常
     */
    @ExceptionHandler(FrameworkException::class)
    fun handleFrameworkException(e: FrameworkException): RestResult<String> {
        logger.error("捕获到框架异常", e)
        return failureRestResult(e)
    }

    /**
     * 其他异常
     */
    @ExceptionHandler(Throwable::class)
    fun handleThrowable(e: Throwable): RestResult<String> {
        logger.error("捕获到未知异常: {}", e.javaClass.name)
        logger.error(e.message, e)
        return failureRestResult(msg = e.message ?: "unknown error")
    }
}