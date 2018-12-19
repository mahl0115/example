package com;

public class GetIndexByValue {

    public static void main(String[] args) {
        int[] array = { 1, 3, 5, 7, 9, 11, 13 };
        getIndexByValue(array, 3);
    }

    /**
     * 
     * @Description: 二分查找算法
     * @param: @param array 有序数组
     * @param: @param value 要查找的元素
     * @param: @return index 要查找元素的下标,没有找到返回-1
     * @result int
     * @author hailong
     * @date 2016年3月29日 下午7:23:24
     */
    public static int getIndexByValue(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (value == array[middle]) {
                return middle;
            } else if (value < array[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

}
