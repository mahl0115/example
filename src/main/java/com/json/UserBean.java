package com.json;

/**
 * Created by mahailong on 16/12/14.
 */
public class UserBean {

    private String Name;

    private String Content;

    private Integer Age;

    public UserBean(String name, String content, Integer age) {
        Name = name;
        Content = content;
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }
}
