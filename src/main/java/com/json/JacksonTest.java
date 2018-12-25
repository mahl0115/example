package com.json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Author mahl
 * @Date 2017-11-15
 */
public class JacksonTest {

    public static void main(String[] args) throws JsonProcessingException {
        UserBean userBean = new UserBean("Li Lei", "I am Li Lei", 20);

        //jackson序列化
        ObjectMapper objectMapper = new ObjectMapper();
        
        objectMapper.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        System.out.println(objectMapper.writeValueAsString(userBean));

        //gson序列化
//        Gson gson = new Gson();
//        System.out.println(gson.toJson(userBean));

    }

}
