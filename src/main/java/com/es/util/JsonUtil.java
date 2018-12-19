package com.es.util;

import com.alibaba.fastjson.JSON;
import com.es.model.Medicine;

public class JsonUtil {

    /**
     * 实现将实体对象转换成json对象
     * 
     * @param medicine Medicine对象
     * @return
     */
    public static String obj2JsonData(Medicine medicine) {
        String str = JSON.toJSONString(medicine);
        return str;
    }
}
