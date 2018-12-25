package com.json.gson;

/**
 * @author mahl
 * @date 2018-04-21
 */
public class Dog {

    private String name;

    private String age;

    public Dog(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
