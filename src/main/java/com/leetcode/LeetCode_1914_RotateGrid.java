package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1914. 循环轮转矩阵
 */
public class LeetCode_1914_RotateGrid {
    public static void main(String[] args) {
        int k = 1;
        int[][] grid = {{40, 10}, {30, 20}};
        new LeetCode_1914_RotateGrid().rotateGrid(grid, k);
        System.out.println("**************************");

        for (int[] item : grid) {
            for (int i = 0; i < item.length; i++) {
                System.out.print(item[i] + " ");
            }
            System.out.println();
        }

    }

    public int[][] rotateGrid(int[][] grid, int k) {

        // 行
        int m = grid.length;
        // 列
        int n = grid[0].length;
        // 层数
        int floors = Math.min(m, n) / 2;
        // 开始每一层继续旋转
        for (int floor = 0; floor < floors; floor++) {
            // 行下标
            List<Integer> row = new ArrayList<>();
            // 列下标
            List<Integer> col = new ArrayList<>();
            // 具体的值
            List<Integer> val = new ArrayList<>();

            // 收集左边的数据
            for (int j = floor; j < m - floor - 1; j++) {
                row.add(j);
                col.add(floor);
                val.add(grid[j][floor]);
            }

            // 收集下边的数据
            for (int j = floor; j < n - floor - 1; j++) {
                row.add(m - floor - 1);
                col.add(j);
                val.add(grid[m - floor - 1][j]);
            }
            // 收集右边的数据
            for (int j = m - floor - 1; j > floor; --j) {
                row.add(j);
                col.add(n - floor - 1);
                val.add(grid[j][n - floor - 1]);
            }

            // 收集上边的数据
            for (int j = n - floor - 1; j > floor; --j) {
                row.add(floor);
                col.add(j);
                val.add(grid[floor][j]);
            }
            // 总的节点数
            int total = val.size();
            // 实际轮转的次数
            int k2 = k % total;

            for (int i = 0; i < total; i++) {
                // total + i 处理第几个节点
                // total + i - k2 轮转k2轮之后的位置
                int index = (total + i - k2) % total;
                grid[row.get(i)][col.get(i)] = val.get(index);
            }

        }

        return grid;
    }
}
