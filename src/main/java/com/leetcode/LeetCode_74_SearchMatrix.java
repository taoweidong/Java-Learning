package com.leetcode;

public class LeetCode_74_SearchMatrix {

    public static void main(String[] args) {
        //
    }

    public boolean searchMatrix(int[][] matrix, int target) {
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
