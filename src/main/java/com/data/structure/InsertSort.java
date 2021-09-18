package com.data.structure;

import java.util.Scanner;

/**
 * 插入排序
 * 
 * @author Taoweidong
 */
public class InsertSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 准备输入数组
            String[] str = sc.nextLine().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.valueOf(str[i]);
            }
            // 开始进行排序
            insertSort(arr);

            // 输出结果
            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length - 1) {
                    System.out.print(arr[i]);
                } else {
                    System.out.print(arr[i] + " ");
                }
            }
        }
    }

    /**
     * 插入排序原理：通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应的位置并插入。
     * 
     * @param arr
     *            待排序数组
     */
    private static void insertSort(int[] arr) {

        // 假设第一个元素被放到正确的位置上，这样可以节省一个数组的空间
        int current;
        for (int i = 1; i < arr.length; i++) {
            // 把第一个数以后的每一个数当做要插入的数据
            current = arr[i];
            int index = i;
            while (index > 0 && current < arr[index - 1]) {
                // 如果后面的数据小于前面的数据，则将前边的数据放到后面的位置
                arr[index] = arr[index - 1];
                index--;
            }
            arr[index] = current;
        }

    }

}
