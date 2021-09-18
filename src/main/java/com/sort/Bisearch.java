package com.sort;

/**
 * 二分查找算法 二分查找操作的数据集是一个有序的数据集。开始时，先找出有序集合中间的那个元素。 如果此元素比要查找的元素大，就接着在较小的一个半区进行查找；反之，如果此元素比要找的元素小，
 * 就在较大的一个半区进行查找。在每个更小的数据集中重复这个查找过程，直到找到要查找的元素或者数据集不能再分割。
 *
 * @author Taoweidong
 */
public class Bisearch {

    public static void main(String[] args) {

        int[] intArr = {2, 5, 6, 7, 9, 10, 25, 63, 88, 96, 100};
        System.out.println(biSearch(intArr, 6));

        System.out.println(biSearch(intArr, 6, 0, intArr.length - 1));

    }

    /**
     * 非迭代方式
     *
     * @param intArr
     *            待查找的升序数组
     * @param target
     *            目标值
     * @return 查找到的索引值
     */
    public static int biSearch(int[] intArr, int target) {
        // 排除特殊情况
        if (intArr == null) {
            return -1;
        }
        if (intArr.length == 1) {
            if (intArr[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        // 正常查找
        int left = 0;
        int right = intArr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (intArr[mid] > target) {
                // 基于当前数组为升序序列的前提：如果目标值小于中间值，则说明目标值在中间值得左侧，应该将右侧right的范围缩小
                right = mid - 1;
            } else if (intArr[mid] < target) {
                // 基于当前数组为升序序列的前提：如果目标值大于中间值，则说明目标值在中间值得右侧，应该将左侧left的范围缩小
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 迭代方式
     *
     * @param intArr
     *            待查找的升序数组
     * @param target
     *            目标值
     * @param left
     *            左边范围
     * @param right
     *            右边范围
     * @return 目标值索引位置
     */
    public static int biSearch(int[] intArr, int target, int left, int right) {
        // 排除特殊情况
        if (intArr == null) {
            return -1;
        }
        if (intArr.length == 1) {
            if (intArr[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        // 注意一定要加此检查条件，防止堆栈溢出
        if (left > right) {
            // 退出迭代条件2：没有找到目标值索引
            return -1;
        }

        // 计算中间位置
        int mid = (left + right) / 2;

        if (intArr[mid] > target) {
            // 基于当前数组为升序序列的前提：如果目标值小于中间值，则说明目标值在中间值得左侧，应该将右侧right的范围缩小
            return biSearch(intArr, target, left, mid - 1);
        } else if (intArr[mid] < target) {
            // 基于当前数组为升序序列的前提：如果目标值大于中间值，则说明目标值在中间值得右侧，应该将左侧left的范围缩小
            return biSearch(intArr, target, mid + 1, right);
        } else {
            // 退出迭代条件1：找到目标值得索引
            return mid;
        }

    }

}
