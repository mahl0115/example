package com.listener.jdk;

import org.apache.commons.lang3.StringUtils;

import java.util.Observable;

public class SimpleObservable extends Observable {

    private String temp;

    public String getData() {
        return temp;
    }

    public void setData(String str) {
        if (StringUtils.isNotBlank(str)) {
            temp = str;

            setChanged();
            // 只有在setChange()被调用后，notifyObservers()才会去调用update()，否则什么都不干。
            notifyObservers();
        }
    }

}
