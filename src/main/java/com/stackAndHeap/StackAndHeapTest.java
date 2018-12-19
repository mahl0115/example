package com.stackAndHeap;

import java.util.ArrayList;

public class StackAndHeapTest {

    public void testHeap() {
        for (;;) {
            ArrayList list = new ArrayList(20000000);
        }
    }

    int num = 1;

    public void testStack() {
        num++;
        this.testStack();
    }

    public static void main(String[] args) {
        StackAndHeapTest t = new StackAndHeapTest();
        t.testHeap();
        // t.testStack();
    }
}
