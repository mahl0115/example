package com.jvm;

/**
 * 
 * @Description: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @author hailong
 * @date 2016年4月18日 上午11:44:11
 */
public class GCTest {

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2097152];
        allocation2 = new byte[2097152];
        allocation3 = new byte[2097152];
        allocation4 = new byte[4194304];// 出现一次Minor GC
    }
}
