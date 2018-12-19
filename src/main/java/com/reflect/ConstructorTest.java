package com.reflect;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;

public class ConstructorTest extends Calendar {

    private static final long serialVersionUID = -8827717282042550136L;

    public ConstructorTest() {
        super();
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // Class<Calendar> ca = Calendar.class;
        // Constructor<Calendar> con = ca.getConstructor();
        Calendar c = ConstructorTest.class.getConstructor().newInstance();
        System.out.println(c.toString());
        // Calendar c = con.newInstance();
        // System.out.println(c.toString());
    }

    @Override
    protected void computeTime() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void computeFields() {
        // TODO Auto-generated method stub

    }

    @Override
    public void add(int field, int amount) {
        // TODO Auto-generated method stub

    }

    @Override
    public void roll(int field, boolean up) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getMinimum(int field) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getMaximum(int field) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getGreatestMinimum(int field) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getLeastMaximum(int field) {
        // TODO Auto-generated method stub
        return 0;
    }
}
