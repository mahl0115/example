package com;

/**
 * 
 * @Description: 二分查找
 * @author hailong
 * @date 2016年5月27日 下午3:00:53
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(2 + 2);
    }

    public static int getIndex(int value) {
        int[] array = { 1, 5, 10, 12, 20, 30, 56, 78, 100, 123, 500, 789 };
        int before = 0;
        int after = array.length - 1;
        while (before <= after) {
            int half = (before + after) / 2;
            if (value > array[half]) {
                before = half + 1;
            } else if (value < array[half]) {
                after = half - 1;
            } else if (value == array[half]) {
                return half;
            }
        }
        return -1;
    }
}
