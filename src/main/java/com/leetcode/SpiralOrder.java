package com.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 54. 螺旋矩阵:给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class SpiralOrder {

    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return Collections.emptyList();
        }
        //标志，右下左上 方向
        int dir = 1;
        //行列
        int row = 0;
        int col = 0;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;

        List<Integer> res = new LinkedList<>();

        while (top <= bottom && left <= right) {
            res.add(matrix[row][col]);

            switch (dir) {
                //  向右边走
                case 1: {
                    //如果走到最右边
                    if (col == right) {
                        //标志位修改：向下走
                        dir = 2;
                        top++;
                        row++;
                        continue;
                    }
                    col++;
                    break;
                }
                //向下边走
                case 2: {
                    //如果走到最下边
                    if (row == bottom) {
                        //修改标志位：向左走
                        dir = 3;
                        right--;
                        col--;
                        continue;
                    }
                    row++;
                    break;
                }
                //向左边走
                case 3: {
                    //如果走到最左边
                    if (col == left) {
                        //修改标志位：向上走
                        dir = 4;
                        bottom--;
                        row--;
                        continue;
                    }
                    col--;
                    break;
                }
                //向上边走
                case 4: {
                    //如果走到最上边
                    if (row == top) {
                        //修改标志位：向右边走
                        dir = 1;
                        left++;
                        col++;
                        continue;
                    }
                    row--;
                }
            }

        }


        return res;
    }
}
