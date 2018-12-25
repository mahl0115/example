package com.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * 按字段/模块过滤客户端展示
 *
 * @author zhangyupeng
 * @date 2017/11/27
 */
public class FilterSerializer extends JsonSerializer<Object> {

    /**
     * 读取MCC中配置的字段过滤
     *
     * @param o
     * @param jsonGenerator
     * @param serializerProvider
     * @throws IOException
     */
    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(o);
        return;
    }
}