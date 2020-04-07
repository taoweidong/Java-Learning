package com.offer;

/**
 * 给定一个二维数组，找到给定坐标周围1的个数
 *
 * @author Taoweidong
 */
public class HuaWeiTest_01 {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 1, 0}, {0, 1, 1, 1, 0}, {0, 1, 1, 1, 0}};

        System.out.println(getCount(arr, 1, 0));

    }

    /**
     * 给定一个二维数组，找到给定坐标周围1的个数
     *
     * @param arr 给定数组
     * @param i   给定数字的横坐标
     * @param j   给定数字的纵坐标
     * @return 包含几个1
     */
    public static int getCount(int[][] arr, int i, int j) {
        int count = 0;

        for (int m = i - 1; m <= i + 1; m++) {
            for (int n = j - 1; n <= j + 1; n++) {
                //检查有没有越界
                if (m < 0 || m > arr.length || n < 0 || n > arr[0].length) {
                    continue;
                }
                //检查是不是当前位置
                if (m == i && n == j) {
                    continue;
                }
                //检查周边元素是否为1，即满足条件
                if (arr[m][n] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
