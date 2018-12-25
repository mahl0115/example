package com;

/**
 * @author mahl
 * @date 2018-07-26
 */
public class ClassloaderTest {

    public static void main(String[] args) {

        System.out.println("Test classLoader is:" + Test.class.getClassLoader().toString());
        System.out.println("Test parent classLoader is:" + Test.class.getClassLoader().getParent().toString());
        System.out.println("Test grandfather classLoader is:" + Test.class.getClassLoader().getParent().getParent().toString());

        System.out.println("int classloader is:" + int.class.getClassLoader());

        System.out.println("String classloader is:" + String.class.getClassLoader());
    }

    static class Test {

    }
}
