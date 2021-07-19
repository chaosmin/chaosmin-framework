package tech.chaosmin.framework.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import tech.chaosmin.framework.entity.OperateResult
import tech.chaosmin.framework.enums.ResultCodeEnum

/**
 * @author Romani min
 * @since 2021/7/19 17:00
 */
internal class JsonUtilTest {

    @Test
    fun encode() {
        val json = JsonUtil.encode(OperateResult<Any>(ResultCodeEnum.SUCCESS.code))
        assertThat(json).isNotNull()
    }

    @Test
    fun decode() {
        val map = JsonUtil.decode("""["key","value"]""", ArrayList::class.java)
        assertThat(map).isNotNull.isExactlyInstanceOf(ArrayList::class.java)
        assertThat(map?.size).isNotNull().isEqualTo(2)
    }

    @Test
    fun testDecode() {
        val map =
            JsonUtil.decode("""{"key":{"key":"value"}}""", HashMap::class.java, String::class.java, HashMap::class.java)
        assertThat(map).isNotNull.isExactlyInstanceOf(HashMap::class.java)
        assertThat(map?.get("key")).isNotNull.isExactlyInstanceOf(HashMap::class.java)
        assertThat((map?.get("key") as Map<*, *>).get("key")).isNotNull.isEqualTo("value")
    }

    @Test
    fun decodeAsMap() {
        val map = JsonUtil.decodeAsMap("""{"key":"value"}""")
        assertThat(map).isNotNull.isExactlyInstanceOf(HashMap::class.java)
        assertThat(map.get("key")).isNotNull().isEqualTo("value")
    }
}