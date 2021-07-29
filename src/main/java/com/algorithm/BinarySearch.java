package com.algorithm;

import java.util.Arrays;

/**
 * 二分查找学习：https://labuladong.gitbook.io/algo/mu-lu-ye/er-fen-cha-zhao-xiang-jie
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // int[] number = {1, 2, 2, 2, 3};
        int target = 2;

        System.out.println(Arrays.toString(number));
        System.out.println(leftBinarySearch(number, target));

    }

    /**
     * 即搜索一个数，如果存在，返回其索引，否则返回 -1
     *
     * @param number
     *            待搜索数组
     * @param target
     *            目标值
     * @return 结果
     */
    public static int binarySearch(int[] number, int target) {
        int left = 0;
        int right = number.length - 1;

        // 此处的搜索区间是一个闭区间，退出条件是 left > right
        while (left <= right) {
            // 注意：使用下面这种方式可以解决溢出的问题
            int mid = left + (right - left) / 2;
            System.out.println(mid);
            if (number[mid] == target) {
                return mid;
            } else if (number[mid] < target) {
                left = mid + 1;
            } else if (number[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 寻找左侧边界的二分搜索
     *
     * @param number
     * @param target
     * @return
     */
    public static int leftBinarySearch(int[] number, int target) {
        int len = number.length;
        if (len == 0) {
            return -1;
        }

        int left = 0;
        // 注意：此处在二分法获取左右边界的时候更加常用，不需要减1
        int right = number.length;
        // 注意：此处的退出条件是left==right
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (number[mid] == target) {
                right = mid;
            } else if (number[mid] < target) {
                left = mid + 1;
            } else if (number[mid] > target) {
                // 因为此处的搜索空间是左闭右开的，这种条件进入是mid已经不满足条件了，此时右边的区间缩小时，右边界为mid,因为右开的特性，此处也不会进行统计
                right = mid;
            }
        }

        return left;
    }

    /**
     * 寻找右侧边界的二分查找
     * 
     * @param number
     * @param target
     * @return
     */
    public static int rightBinarySearch(int[] number, int target) {
        int len = number.length;
        if (len == 0) {
            return -1;
        }

        int left = 0;
        // 注意：此处在二分法获取左右边界的时候更加常用，不需要减1
        int right = number.length;
        // 注意：此处的退出条件是left==right
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (number[mid] == target) {
                // 注意：
                left = mid + 1;
            } else if (number[mid] < target) {
                left = mid + 1;
            } else if (number[mid] > target) {
                right = mid;
            }
        }

        // 注意：
        return right - 1;
    }

    public static int leftBinarySearch22(int[] number, int target) {
        int len = number.length;
        if (len == 0) {
            return -1;
        }

        int left = 0;
        // 注意：此处在二分法获取左右边界的时候更加常用，不需要减1
        int right = number.length - 1;
        // 注意：此处的退出条件是left==right
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (number[mid] == target) {
                right = mid - 1;
            } else if (number[mid] < target) {
                left = mid + 1;
            } else if (number[mid] > target) {
                right = mid - 1;
            }
        }

        if (left >= len || number[left] != target) {
            return -1;
        }

        return left;
    }

    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int left = 1;
        int right = x / 2 + 1;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = (int)(mid - 1);
            } else if (mid * mid < x) {
                left = (int)(mid + 1);
            } else {
                return (int)mid;
            }
        }
        return right;
    }
}
