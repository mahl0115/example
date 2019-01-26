package com.json;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Created by mahailong on 17/5/19.
 */
public class Test {

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println(JSON.toJSONString(new User("1", "2", "3")));
    }
}
