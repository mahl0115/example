package com.json.gson;

import com.google.gson.*;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author mahl
 * @date 18/1/29
 */
public class FilterTypeAdapter implements JsonSerializer<String> {

    /**
     * 读取MCC中配置的字段过滤
     *
     * @param o
     * @param type
     * @param jsonSerializationContext
     * @throws IOException
     */
    @Override
    public JsonElement serialize(String o, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(o);
        //return jsonSerializationContext.serialize(o, type);
    }
}