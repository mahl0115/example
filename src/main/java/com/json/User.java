package com.json;

/**
 * Created by mahailong on 16/12/14.
 */
public class User {

    private String sort;

    private String name;

    private String content;

    public User() {
    }

    public User(String sort, String name, String content) {
        this.sort = sort;
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }


}
