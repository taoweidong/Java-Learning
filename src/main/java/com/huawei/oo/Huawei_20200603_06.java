package com.huawei.oo;

import java.util.Scanner;

/**
 * # 【服务器问题】----【本题的题意和求岛屿的最大面积是一样的，算法思路也相同：https://leetcode-cn.com/problems/max-area-of-island/】
 * 在一机屋中、服务器的作置标识再 n*m矩阵网络中，1表示单元格上有服务四，0表示没有，
 * 如果两台服务器位于同一行，或者同一列中紧邻的位置，则认为他们之间可以组或一个局域，请你统计机房中最大的局城网包含的服务器个数，
 * <p>
 * 【注意】：此题和leetCode上的不一致
 * 【注意点1】：如果两台服务器位于同一行，或者同一列中紧邻的位置，则认为他们之间可以组或一个局域---必须紧邻，才能构成一个局域网
 * 【注意点2】：请你统计机房中最大的局城网包含的服务器个数---输出结果为最大局域网的服务器个数
 * - 输入描述，：
 * 第1行输入两个正整数，n和m,n大于0,m＜=100.
 * 之后为n*m得二维数组，，代表服务器信息，
 * <p>
 * - 输出
 * 最大局城网包含的服务器个数，
 * <p>
 * 输入
 * 2 2
 * 1 0
 * 1 1
 * 输出：3
 * <p>
 * 输入：
 * 4 4
 * 1 1 0 1 0
 * 1 0 0 1 0
 * 0 0 0 1 0
 * 1 0 0 1 1
 * 输出： 5
 * <p>
 * 输入：
 * 4 4
 * 1 1 0 1 0
 * 1 0 0 1 0
 * 0 0 0 0 0
 * 1 0 0 1 1
 * 输出： 3
 */
public class Huawei_20200603_06 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] input = sc.nextLine().trim().split(" ");
            int n = Integer.valueOf(input[0]);
            int m = Integer.valueOf(input[1]);

            //收集数据
            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] temp = sc.nextLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = Integer.valueOf(temp[j]);
                }
            }
            //进行逻辑计算
            int count = maxAreaOfIsland(grid);
            System.out.println(count);

        }

//        int[][] grid = {{1, 0}, {1, 1}};
//        int[][] grid = {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
//        int[][] grid = {{1, 1, 0, 1, 0}, {1, 0, 0, 1, 0}, {0, 0, 0, 0, 0}, {1, 0, 0, 1, 1}};
//        int count = maxAreaOfIsland(grid);
//        System.out.println(count);
    }

    public static int maxAreaOfIsland(int[][] grid) {

        //岛屿的最大面积
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }

        return res;

    }

    private static int dfs(int[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }

        //标识子节点已经遍历过了
        grid[i][j] = 0;
        // 每次调用的时候默认num为1，进入后判断如果不是岛屿，则直接返回0，就可以避免预防错误的情况。
        // 每次找到岛屿，则直接把找到的岛屿改成0，这是传说中的沉岛思想，就是遇到岛屿就把他和周围的全部沉默。
        int num = 1;
        num += dfs(grid, i - 1, j);
        num += dfs(grid, i + 1, j);
        num += dfs(grid, i, j - 1);
        num += dfs(grid, i, j + 1);

        return num;
    }
}


