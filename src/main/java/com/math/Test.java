package com.math;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author mahl
 * @date 2018-03-14
 */
public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException, UnknownHostException {
        String a = "中";
        
        System.out.println("UTF-8编码长度:" + a.getBytes("UTF-8").length);
        System.out.println("GBK编码长度:" + a.getBytes("GBK").length);
        System.out.println("GB2312编码长度:" + a.getBytes("GB2312").length);

        System.out.println(InetAddress.getLocalHost().getHostAddress());
    }
}
