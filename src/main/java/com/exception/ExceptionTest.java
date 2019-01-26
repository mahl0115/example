package com.exception;

/**
 * Created by mahailong on 16/8/30.
 */
public class ExceptionTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            try {
                if (i == 1) {
                    throw new RuntimeException();
                }
                System.out.println(i);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }
}
