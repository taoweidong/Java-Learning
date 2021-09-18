package com.sort;

import com.alibaba.fastjson.JSON;

/**
 * 选择排序 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置， 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。 以此类推，直到所有元素均排序完毕 算法分析：最佳情况：T(n) = O(n2)
 * 最差情况：T(n) = O(n2) 平均情况：T(n) = O(n2)
 *
 * @author Taoweidong
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {10, 2, 3, 56, 24, 12, 9, 85, 533, 62};
        System.out.println(JSON.toJSONString(arr));
        selectionSort(arr);
        System.out.println(JSON.toJSONString(arr));
    }

    /**
     * 选择排序
     *
     * @param array
     *            待排序的数组
     */
    public static void selectionSort(int[] array) {
        if (array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length; i++) {

            // i:当前的i就是已经排序的的后一个位置，这个位置的数据也属于没有排序的元素，所以也参与下面找最小值索引的方法

            // 遍历剩余没有排序的元素，找到最小值的索引
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                // 找到最小值
                if (array[j] < array[minIndex]) {
                    // 保存最小值的索引
                    minIndex = j;
                }
            }

            // 将当前的开始位置i和最小值索引minIndex的值交换，这样当前位置i中存放的就是当前剩余待排序数字中的最小值
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
