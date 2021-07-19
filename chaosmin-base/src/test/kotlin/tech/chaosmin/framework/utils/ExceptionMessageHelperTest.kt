package tech.chaosmin.framework.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import tech.chaosmin.framework.enums.ResultCodeEnum

/**
 * @author Romani min
 * @since 2021/7/19 16:29
 */
internal class ExceptionMessageHelperTest {

    @Test
    fun getMsg() {
        val msg = ExceptionMessageHelper.getMsg(ResultCodeEnum.FAILURE.code)
        assertThat(msg).isNotNull().isEqualTo("系统异常:{0};")
    }

    @Test
    fun testGetMsg() {
        val msg = ExceptionMessageHelper.getMsg(ResultCodeEnum.FAILURE.code, "测试失败")
        assertThat(msg).isNotNull().isEqualTo("系统异常:测试失败;")
    }
}