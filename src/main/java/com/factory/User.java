package com.factory;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class User {

    private String name;

    private int sex;

    private int age;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        System.out.println(User.builder().name("123").sex(1).build().toString());
    }

}
