package com.example.springboottemplate.config.redis;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.crazycake.shiro.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CustomJackson2JsonRedisSerializer<T> implements RedisSerializer<T> {

  public static final Charset DEFAULT_CHARSET;
  private final JavaType javaType;
  private ObjectMapper objectMapper = new ObjectMapper();

  public CustomJackson2JsonRedisSerializer(Class<T> type) {
    this.javaType = this.getJavaType(type);
  }

  public T deserialize(@Nullable byte[] bytes) throws SerializationException {
    if (bytes == null || bytes.length == 0) {
      return null;
    } else {
      try {
        return this.objectMapper.readValue(bytes, 0, bytes.length, this.javaType);
      } catch (Exception var3) {
        throw new SerializationException("Could not read JSON: " + var3.getMessage(), var3);
      }
    }
  }

  public byte[] serialize(@Nullable Object t) throws SerializationException {
    if (t == null) {
      return new byte[0];
    } else {
      try {
        return this.objectMapper.writeValueAsBytes(t);
      } catch (Exception var3) {
        throw new SerializationException("Could not write JSON: " + var3.getMessage(), var3);
      }
    }
  }

  public void setObjectMapper(ObjectMapper objectMapper) {
    Assert.notNull(objectMapper, "'objectMapper' must not be null");
    this.objectMapper = objectMapper;
  }

  protected JavaType getJavaType(Class<?> clazz) {
    return TypeFactory.defaultInstance().constructType(clazz);
  }

  static {
    DEFAULT_CHARSET = StandardCharsets.UTF_8;
  }
}
