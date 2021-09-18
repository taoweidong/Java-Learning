package com.offer;

/**
 * @author Taowd
 * @Description 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

public class FindArray {

    public static void main(String[] args) {

        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int target = 7;
        // System.out.println(Find(target, arr));
        System.out.println(Find2(target, arr));
    }

    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean Find(int target, int[][] array) {

        boolean falg = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == target) {
                    return true;
                } else {
                    falg = false;
                }
            }
        }
        return falg;
    }

    /**
     * 推荐算法 比较难理解
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean Find2(int target, int[][] array) {

        int row = 0;
        int col = array[0].length - 1;
        while (row <= array.length - 1 && col >= 0) {
            if (target == array[row][col]) {
                return true;
            } else if (target > array[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

}
