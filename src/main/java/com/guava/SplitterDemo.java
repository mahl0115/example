package com.guava;

import com.google.common.base.Splitter;

import java.util.List;

/**
 * Created by mahailong on 16/10/31.
 */
public class SplitterDemo {

    private static String array = " <br>, <ul>, <li>, <p>, <h1>, <h2>, <h3>, <h4>, <h5>, <h6>";

    public static void main(String[] args) {
        List<String> list = Splitter.on(",")
                                    .trimResults()
                                    .splitToList(array);
        for(String s :list){
            System.out.println(s);
        }
    }
}
