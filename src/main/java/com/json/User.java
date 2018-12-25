package com.json;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by mahailong on 16/12/14.
 */
public class User {

    @JSONField(name = "sort")
    private String Sort;

    @JSONField(name = "name")
    private String Name;

    @JSONField(name = "content")
    private String Content;

    public User(String sort, String name, String content) {
        Sort = sort;
        Name = name;
        Content = content;
    }

    public String getSort() {
        return Sort;
    }

    public void setSort(String sort) {
        Sort = sort;
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

}
