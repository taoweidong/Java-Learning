package com.sort;

import com.alibaba.fastjson.JSON;

/**
 * 快速排序实现
 *
 * @author Taoweidong
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {10, 2, 3, 56, 24, 12, 9, 85, 533, 62};
        System.out.println(JSON.toJSONString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(JSON.toJSONString(arr));

    }

    /**
     * 快速排序算法
     *
     * @param arr
     *            待排序的数组
     * @param left
     *            左边区域
     * @param right
     *            右边区域
     */
    public static void quickSort(int[] arr, int left, int right) {

        // 递归退出条件
        if (left >= right) {
            return;
        }
        // 计算基准数据的位置
        int partition = getPartition(arr, left, right);
        // 递归对左边进行快速排序
        quickSort(arr, left, partition - 1);
        // 递归对右边进行排序
        quickSort(arr, partition + 1, right);

    }

    public static int getPartition(int[] arr, int left, int right) {
        int partition = arr[left];

        while (left < right) {
            // 从右往左找一个比基线小的数据，然后和基线进行交换
            while (left < right && arr[right] >= partition) {
                right--;
            }

            if (left < right) {
                arr[left] = arr[right];
                left++;
            }

            // 从左往右找一个比基线大的数据，放在右边的位置上
            while (left < right && arr[left] < partition) {
                left++;
            }

            if (left < right) {
                arr[right] = arr[left];
                right--;
            }

        }
        // 遍历完毕后，把基线放在正确的位置上
        arr[left] = partition;
        // 返回基线索引
        return left;
    }

    /**
     * 核心逻辑：将给定数组的给定区间进行快速排序，并返回排序后基准值得为之，为后续的分区间迭代排序提供条件
     *
     * @param arr
     *            待排序数据
     * @param left
     *            左边区间
     * @param right
     *            右边区间
     * @return 基准值得位置
     */
    private static int partition(int[] arr, int left, int right) {
        // 将第一个数作为基准值。挖坑 设置基准值：初始基准值为最左边的数据
        int partition = arr[left];

        // 使用循环实现分区操作
        while (left < right) {

            // 从右向左移动j，找到第一个小于基准值的值 arr[right]
            while (left < right && arr[right] >= partition) {
                --right;
            }

            if (left < right) {
                arr[left] = arr[right];
                ++left;
            }

            // 从左向右移动i，找到第一个大于等于基准值的值 arr[left]
            while (left < right && arr[left] < partition) {
                left++;
            }

            if (left < right) {
                arr[right] = arr[left];
                --right;
            }
        }

        // 使用基准值填坑，这就是基准值的最终位置
        arr[left] = partition;
        // 返回基准值的位置索引
        return left;
    }

}
