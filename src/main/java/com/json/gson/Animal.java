package com.json.gson;

/**
 * @author mahl
 * @date 2018-04-21
 */
public class Animal<T> {

    private String a;

    public Dog dog;

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
