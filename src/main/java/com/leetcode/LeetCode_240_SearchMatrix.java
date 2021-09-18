package com.leetcode;

public class LeetCode_240_SearchMatrix {
    public static void main(String[] args) {
        // int[][] matrix = {
        // {1, 4, 7, 11, 15},
        // {2, 5, 8, 12, 19},
        // {3, 6, 9, 16, 22},
        // {10, 13, 14, 17, 24},
        // {18, 21, 23, 26, 30}
        // };
        // int target = 5;

        // int[][] matrix = {{-5}};
        // int target = -5;

        int[][] matrix = {{-5}};
        int target = -10;

        System.out.println(new LeetCode_240_SearchMatrix().searchMatrix2(matrix, target));
    }

    /**
     * 暴力进行搜索
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // 原始暴力解法
        // 根据题目特性，这个元素肯定是唯一的，不存在多个元素的情况
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // ***************************************************************************************************************

    /**
     * 找到递增规律使用二分处理
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {

        for (int row = 0, col = matrix[0].length - 1; row <= matrix.length - 1 && col >= 0;) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }

        return false;
    }
}
