package com.nowcoder;

import java.util.ArrayList;

/**
 * @ClassName PrintMatrix
 * @Description 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字， 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 *              则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @Author Taowd
 * @Version V1.0
 */
public class PrintMatrix {

    public static void main(String[] args) {

        int[][] data = {{1, 2, 3, 4}, {5, 6, 7, 8,}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("---------------------------------");

        // 魔方旋转一次
        // 总列数
        int col = data[0].length;
        // 总行数
        int row = data.length;
        // 定义新的数组结构，旋转之后的数组结构
        int[][] newMatrix = new int[col][row];
        // 每一列
        for (int i = col - 1; i >= 0; i--) {
            // 每一行
            for (int j = 0; j < row; j++) {
                // 执行旋转逻辑
                newMatrix[col - i - 1][j] = data[j][i];
            }
        }

        // 打印旋转之后的数组结构
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                System.out.print(newMatrix[i][j] + "\t");
            }
            System.out.println();
        }

        // ArrayList<Integer> arrayList = printMatrix(data);
        //
        // for (Integer item : arrayList) {
        // System.out.print(item + " ");
        // }
    }

    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字， 思路：模拟魔方逆时针旋转的方法，一直做取出第一行的操作
     *
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> printMatrix(int[][] matrix) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int row = matrix.length;// 总行数
        while (row != 0) {// 检查总行数是否大于0
            for (int i = 0; i < matrix[0].length; i++) {
                arrayList.add(matrix[0][i]);
            }
            if (row == 1) {
                break;
            }
            matrix = turn(matrix);
            row = matrix.length;
        }
        return arrayList;
    }

    /**
     * 取出第一行然后二维旋转
     *
     * @param matrix
     * @return
     */
    private static int[][] turn(int[][] matrix) {

        int col = matrix[0].length;// 总行数
        int row = matrix.length;// 总列数
        int[][] newMatrix = new int[col][row - 1];
        for (int i = col - 1; i >= 0; i--) {
            for (int j = 1; j < row; j++) {
                newMatrix[col - 1 - i][j - 1] = matrix[j][i];
            }
        }
        return newMatrix;
    }
}
