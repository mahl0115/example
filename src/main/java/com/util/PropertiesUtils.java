package com.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtils {

    public static OrderedProperties load(String path) {
        OrderedProperties properties = new OrderedProperties();
        try {
            properties.load(new InputStreamReader(PropertiesUtils.class.getClassLoader().getResourceAsStream(path), "UTF-8"));
        } catch (IOException e) {
            throw new IllegalArgumentException(path + "file not found");
        }
        return properties;
    }


    public static void main(String[] args) throws IOException {
        Properties pro = PropertiesUtils.load("practical_relation.properties");
        System.out.println(pro.get("showAvgprice"));
    }
}
