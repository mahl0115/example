package com;

public class RuntimeConstantpoolOOM {

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        // System.out.println(str1);
        // System.out.println(str1.intern());
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        // System.out.println(str2);
        // System.out.println(str2.intern());
        System.out.println(str2.intern() == str2);

        String str3 = new StringBuilder("d").append("og").toString();
        // System.out.println(str3);
        // System.out.println(str3.intern());
        System.out.println(str3.intern() == str3);

        String str4 = new StringBuilder("pub").append("lic").toString();
        // System.out.println(str3);
        // System.out.println(str3.intern());
        System.out.println(str4.intern() == str4);
    }
}
