package com;

import com.es.model.User;
import com.google.common.collect.Lists;

import java.util.List;

public class TestOOM {

    //List<DataObject> list = new ArrayList<DataObject>();
    public static void main(String[] args) {
        List<User> list = Lists.newArrayList();
        while (true) {
            list.add(new User());
        }
    }

}
