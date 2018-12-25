package com.json;

import java.util.List;

/**
 * Created by mahailong on 16/12/14.
 */
public class RoomAmenityModel {

    /**
     * 属性唯一标识
     */
    private Integer id;

    /**
     * 组
     */
    private String type;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 映射关系
     */
    private List<IdNameDo> value;

    /**
     * 展示的内容
     */
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<IdNameDo> getValue() {
        return value;
    }

    public void setValue(List<IdNameDo> value) {
        this.value = value;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}