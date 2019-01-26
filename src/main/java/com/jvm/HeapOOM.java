package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Description: VM Args: -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError -verbose:gc -Xms20M -Xmx20M -Xmn10M
 *               -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @author hailong
 * @date 2016年3月10日 下午2:40:41
 */
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
    }

}
