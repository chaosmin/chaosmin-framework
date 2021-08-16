package tech.chaosmin.framework.exception.support

import tech.chaosmin.framework.exception.FrameworkException
import tech.chaosmin.framework.utils.PropertiesLoader
import java.text.MessageFormat
import java.util.*

/**
 * 系统框架级异常错误返回消息解析工具 <p>
 * @author Romani min
 * @since 2021/7/16 18:16
 */
object ExceptionMessageHelper {
    private var properties = Properties()
    private var isInit = false

    init {
        getProperties()
    }

    private fun getProperties(): Properties {
        if (!isInit) {
            synchronized(properties) {
                if (!isInit) {
                    properties = PropertiesLoader(ExceptionMsgPath.FRM_EXCEPTION_MSG.path).getProperties()
                    isInit = true
                }
            }
        }
        return properties
    }

    fun getMsg(code: String?): String {
        return if (null == code) "SYSTEM_ERROR"
        else try {
            getProperties().getProperty(code) ?: "ERROR_CODE_NOT_DEFINED: $code"
        } catch (var3: Exception) {
            throw FrameworkException("SYSTEM_ERROR", var3)
        }
    }


    fun getMsg(code: String?, vararg args: Any): String = MessageFormat.format(getMsg(code), *args)
}