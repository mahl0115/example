package com.file;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.beans.Transient;

/**
 * @author mahl
 * @date 2018-04-17
 */
public class Select {

    private String id;

    @JsonIgnore
    private String name;

    @JsonIgnore
    private String grade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
