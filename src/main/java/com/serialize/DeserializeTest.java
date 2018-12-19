package com.serialize;

import com.alibaba.fastjson.JSONObject;
import com.es.model.User;

/**
 * 反序列化测试
 *
 * @author mahl
 * @create 2017-07-06
 */
public class DeserializeTest {

    public static void main(String[] args) {
        User user = new User();

        JSONObject paramJson = new JSONObject();
        paramJson.put("id", 1);
        paramJson.put("age", 2);
        paramJson.put("name", "3");
        paramJson.put("introduce", "4");

        User user1 = JSONObject.parseObject(paramJson.toString(), User.class);
        System.out.println(JSONObject.toJSONString(user1));
    }
}
