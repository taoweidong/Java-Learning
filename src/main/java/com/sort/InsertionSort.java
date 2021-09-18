package com.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author Taoweidong
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {10, 2, 3, 56, 24, 12, 9, 85, 533, 62};
        System.out.println(JSON.toJSONString(arr));
        insertionSort(arr);
        System.out.println(JSON.toJSONString(arr));
    }

    /**
     * 插入排序
     *
     * @param arr
     *            待排序数组
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            // 待插入的数据
            int currentValue = arr[i + 1];
            // 当前位置往前都为已经排好序的数据
            int index = i;
            while (index >= 0 && arr[index] > currentValue) {
                // 如果当前位置的值小于待插入的数据，则将该位置的数据往后挪一位
                // 当前位置的下一个位置为占位的数据
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = currentValue;
        }

    }
}
