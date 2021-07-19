package tech.chaosmin.framework.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import tech.chaosmin.framework.exception.support.ExceptionMsgPath

/**
 * @author Romani min
 * @since 2021/7/19 16:55
 */
internal class PropertiesLoaderTest {
    lateinit var propertiesLoader: PropertiesLoader

    @BeforeEach
    fun setUp() {
        propertiesLoader = PropertiesLoader(ExceptionMsgPath.FRM_EXCEPTION_MSG.path)
    }

    @Test
    fun getProperties() {
        val properties = propertiesLoader.getProperties()
        assertThat(properties).isNotNull
    }

    @Test
    fun getProperty() {
        val msg = propertiesLoader.getProperty("SYS_00001")
        assertThat(msg).isNotNull().isEqualTo("系统异常:{0};")
    }

    @Test
    fun getPropertyWithDefault() {
        val msg = propertiesLoader.getProperty("SYS_99999", "未知异常")
        assertThat(msg).isNotNull().isEqualTo("未知异常")
    }
}