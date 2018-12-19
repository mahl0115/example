package com;

public class DataObject {

    // 数据对象ID
    private String id;
    // 数据对象内容
    private String des;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "DataObject [id=" + id + ", des=" + des + "]";
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

    }
}
