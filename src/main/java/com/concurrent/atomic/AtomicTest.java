package com.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicTest {

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {

            }
        };
    }

    // @Immutable
    private static class IntPair {
        final int lower;// 不变性条件：lower <= upper
        final int upper;

        public IntPair(int i, int j) {
            lower = i;
            upper = j;
        }

    }

    private final AtomicReference<IntPair> values = new AtomicReference<IntPair>(new IntPair(0, 0));

    public int getLower() {
        return values.get().lower;
    }

    public int getUpper() {
        return values.get().upper;
    }

    public void setLower(int i) {
        while (true) {
            IntPair oldv = values.get();
            if (i > oldv.upper) {
                throw new IllegalArgumentException("Can't set lower to " + i + " > upper");
            }
            IntPair newv = new IntPair(i, oldv.upper);
            if (values.compareAndSet(oldv, newv)) {
                return;
            }
        }
    }

    public void setUpper(int i) {
        while (true) {
            IntPair oldv = values.get();
            if (i < oldv.lower) {
                throw new IllegalArgumentException("Can't set upper to " + i + " < lower");
            }
            IntPair newv = new IntPair(i, oldv.lower);
            if (values.compareAndSet(oldv, newv)) {
                return;
            }
        }
    }
}
