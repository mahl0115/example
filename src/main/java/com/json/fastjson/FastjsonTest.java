package com.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.Gson;

/**
 * 结论：public属性>public getter/setter
 * Created by mahailong on 17/5/19.
 */
public class FastjsonTest {

    public static void main(String[] args) {
        User user = new User("test", "test", "test");
        //序列化
        System.out.println(JSON.toJSONString(user));

        //String json = JSON.toJSONString(user);
        //反序列化
        System.out.println(new Gson().toJson(JSON.parseObject("{\"a\":\"test\",\"b\":\"test\",\"c\":\"test\"}", User.class)));
    }

    static class User {

        @JSONField(name = "a")
        public String Sort;

        @JSONField(name = "b")
        public String Name;

        @JSONField(name = "c")
        public String Content;

        public User() {
        }

        public User(String sort, String name, String content) {
            Sort = sort;
            Name = name;
            Content = content;
        }
    }
}
