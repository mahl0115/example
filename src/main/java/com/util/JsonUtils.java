package com.util;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by mahailong on 16/11/14.
 */
public class JsonUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final ObjectMapper withoutDefaultMapper = new ObjectMapper();

    private static final Gson gson = new Gson();

    static {
        //属性为默认值不序列化
        withoutDefaultMapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
        //bean为空不报错
        withoutDefaultMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        //有属性不能映射成PO时不报错
        withoutDefaultMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        //NULL 不序列化
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //bean为空不报错
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        //有属性不能映射成PO时不报错
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    /**
     * string转bean
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T toBean(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
        }
        return gson.fromJson(json, clazz);
    }

    /**
     * object转string
     *
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            String json = toJsonByGson(obj);
            //LOGGER.error("{} Jackson parse error. obj={}", XMDLogFormat.build(), json, e);
            return json;
        }
    }

    /**
     * object转string gson
     *
     * @param obj
     * @return
     */
    public static String toJsonByGson(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * obj转jsonNode
     *
     * @param obj
     * @return
     */
    public static JsonNode toJsonNode(Object obj) throws IOException {
        return objectMapper.readTree(objectMapper.writeValueAsString(obj));
    }

    /**
     * object转string,图片链接会处理(域名后会添加w.h/)
     *
     * @param obj
     * @return
     */
    public static String toJsonByFilter(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    /**
     * object转string
     *
     * @param obj
     * @return
     */
    public static String toJsonNotWriteDefaultValue(Object obj) throws JsonProcessingException {
        return withoutDefaultMapper.writeValueAsString(obj);
    }

    /**
     * object[] 转 string
     *
     * @param array
     * @return
     */
    public static String toJson(Object[] array) {
        List<String> list = Lists.newArrayList();
        if (array != null && array.length > 0) {
            for (Object obj : array) {
                try {
                    list.add(objectMapper.writeValueAsString(obj));
                } catch (JsonProcessingException e) {
                    LOGGER.error("{} Json writeValueAsString error. obj={}", obj, e);
                }
            }
            return Joiner.on(",").join(list);
        }
        return "";
    }

    /**
     * string 转 list
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> toArray(String json, Class<T> clazz) {
        return JSONObject.parseArray(json, clazz);
    }

    /**
     * string 转 list
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> toList(String json, Class<T> clazz) {
        return gson.fromJson(json,
                new TypeToken<List<T>>() {
                }.getType());
    }

    /**
     * string 转 jsonobject
     *
     * @param json
     * @return
     */
    public static JsonObject toJsonObject(String json) {
        return gson.fromJson(json, JsonObject.class);
    }
}


