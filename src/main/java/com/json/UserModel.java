package com.json;

/**
 * Created by mahailong on 17/5/19.
 */
public final class UserModel {
    private String sort;
    private String name;
    private String content;

    private UserModel() {
    }

    public static UserModel anUser() {
        return new UserModel();
    }

    public UserModel buildSort(String sort) {
        this.sort = sort;
        return this;
    }

    public UserModel buildName(String name) {
        this.name = name;
        return this;
    }

    public UserModel buildContent(String content) {
        this.content = content;
        return this;
    }

    public User build() {
        User user = new User();
        user.setSort(sort);
        user.setName(name);
        user.setContent(content);
        return user;
    }
}
