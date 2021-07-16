package tech.chaosmin.framework.utils

import com.fasterxml.jackson.core.JsonGenerationException
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.type.TypeFactory
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Jackson Json解析处理工具 <p>
 * @author Romani min
 * @since 2021/7/16 18:43
 */
object JsonUtil {
    private val logger: Logger = LoggerFactory.getLogger(JsonUtil::class.java)

    private val objectMapper = ObjectMapper().apply {
        findAndRegisterModules()
        // 允许 Java风格 注释
        configure(JsonParser.Feature.ALLOW_COMMENTS, true)
        // 允许 Yaml风格 注释
        configure(JsonParser.Feature.ALLOW_YAML_COMMENTS, true)
        // 允许单引号
        configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
        // 格式化输出
        configure(SerializationFeature.INDENT_OUTPUT, false)
        // 默认时间格式
        dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA)
    }

    /**
     * 序列化实体对象为字符串
     * @param obj 需要序列化的实体对象
     * @param prettyPrinter 是否格式化字符串, 默认为否
     * @return [String] 将对象序列化之后的字符串
     */
    fun encode(obj: Any?, prettyPrinter: Boolean = false): String {
        return if (obj == null) ""
        else try {
            if (!prettyPrinter) objectMapper.writeValueAsString(obj)
            else objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj)
        } catch (e: JsonGenerationException) {
            logger.error("encode(obj) JsonGenerationException: ${e.message}", e)
            return ""
        } catch (e: JsonMappingException) {
            logger.error("encode(obj) JsonMappingException: ${e.message}", e)
            return ""
        } catch (e: IOException) {
            logger.error("encode(obj) IOException: ${e.message}", e)
            return ""
        }
    }

    /**
     * 反序列化字符串为实体对象
     * @param json Json字符串
     * @param valueType 对象的Java类型
     * @return [T] 实体对象
     */
    fun <T> decode(json: String?, valueType: Class<T>): T? {
        if (json.isNullOrBlank()) return null
        return try {
            objectMapper.readValue(json, valueType)
        } catch (e: JsonGenerationException) {
            logger.error("decode(String, Class<T>) JsonGenerationException: ${e.message}", e)
            null
        } catch (e: JsonMappingException) {
            logger.error("decode(String, Class<T>) JsonMappingException: ${e.message}", e)
            null
        } catch (e: IOException) {
            logger.error("decode(String, Class<T>) IOException: ${e.message}", e)
            null
        }
    }

    /**
     * 反序列化字符串为实体对象 <p>
     * 当需要反序列化的对象是个泛型结构时, 使用该方法传入泛型类型
     * @param json Json字符串
     * @param valueType 对象的Java类型
     * @param elementClasses 对象Java类型的泛型参数
     * @return [T] 实体对象
     */
    fun <T> decode(json: String?, valueType: Class<T>, vararg elementClasses: Class<*>): T? {
        if (json.isNullOrBlank()) return null
        val javaType = objectMapper.typeFactory.constructParametricType(valueType, *elementClasses)
        return objectMapper.readValue(json, javaType)
    }

    /**
     * 将Json字符串转换为Map类型
     * @param json Json字符串
     * @return [Map] 映射对象
     */
    fun decodeAsMap(json: String?): Map<String, String> {
        if (json.isNullOrBlank()) return emptyMap()
        val typeFactory = TypeFactory.defaultInstance()
        val constructMapType = typeFactory.constructMapType(HashMap::class.java, String::class.java, String::class.java)
        return objectMapper.readValue(json, constructMapType)
    }
}