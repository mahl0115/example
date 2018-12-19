package com.string;

/**
 * aa
 *
 * @author mahl
 * @create 2017-05-23
 */
public class Test {

    public static void main(String[] args) {
        String str = "中午12";
        str = str.trim();
        String str2 = "";
        if (str != null && !"".equals(str)) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                    str2 += str.charAt(i);
                }
            }

        }
        System.out.println(str2);
    }
}
