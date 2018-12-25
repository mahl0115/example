package com.json.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;


/**
 * Created by yuqiliu on 2018/8/15.
 */
public class GsonUtil {

    private static Gson gson;

    static {
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    }

    public static String toJson(Object var){
        return gson.toJson(var);
    }

    public static <T> T fromJson(String var1, Type var2){
        return gson.fromJson(var1, var2);
    }

    public static <T> T fromJson(String var1, Class<T> var2){
        return gson.fromJson(var1, var2);
    }

    public static void main(String[] args) {
        String msg = "{\"paymentNo\":\"ZF20181012370021548\",\"outTradeNo\":\"2018101222001478040545617160\",\"tradeNo\":\"GW2018101260000021973\",\"payMethod\":1,\"payAmount\":0.01,\"repairId\":\"6e3bf3f8bda34ee1b1777fdc9e1be80b\",\"repairName\":\"ptt鐨勪慨鐞嗗巶\",\"payTime\":1539318570029,\"payRelationMQDtoList\":[{\"paymentNo\":\"ZF20181012370021548\",\"businessNo\":\"DD20181012960028774\",\"businessAmount\":0.01,\"finishTime\":null,\"createTime\":1539318562000,\"freightPrice\":0.00,\"goodsInfoMQDtoList\":[{\"businessId\":\"DD20181012960028774\",\"goodsId\":\"BZ153810682264201\",\"goodsName\":\"姘寸\uE188\",\"goodsPrice\":\"0.01\",\"goodsNumber\":1}]}]}";
        //String msg = "{\"payTime\":1539318570029}";
        OnlinePaymentMQDto onlinePaymentMQDto = fromJson(msg, OnlinePaymentMQDto.class);
        System.out.println(onlinePaymentMQDto.toString());
    }

}
