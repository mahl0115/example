package com.reflect;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public class User implements Closeable, Flushable {

    private int id;

    private String name;

    private int sex;

    private int age;

    public User(int id, String name, int sex, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public void flush() throws IOException {

    }

    //    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return this.name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getSex() {
//        return this.sex;
//    }
//
//    public void setSex(int sex) {
//        this.sex = sex;
//    }
//
//    public int getAge() {
//        return this.age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }

}
