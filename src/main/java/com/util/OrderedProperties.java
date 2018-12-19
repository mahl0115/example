package com.util;

import java.util.*;

/**
 * Created by mahailong on 16/10/22.
 */
public class OrderedProperties extends Properties {

    private final LinkedHashSet keys = new LinkedHashSet();

    public Enumeration keys() {
        return Collections.enumeration(keys);
    }

    public Object put(Object key, Object value) {
        keys.add(key);
        return super.put(key, value);
    }

    public synchronized Object remove(Object key) {
        keys.remove(key);
        return super.remove(key);
    }

    public Set keySet() {
        return keys;
    }

    public List<Integer> getPropertyNames() {
        //Set<String> set = new LinkedHashSet<>();
        List<Integer> keys = new ArrayList<Integer>();
        for (Object key : this.keys) {
            keys.add(Integer.parseInt(key.toString()));
        }
        return keys;
    }
}
