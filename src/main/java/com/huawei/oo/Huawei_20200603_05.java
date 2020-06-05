package com.huawei.oo;

import java.util.Scanner;

/**
 * # 【服务器问题】
 * 在一机屋中、服务器的作置标识再 nXm矩阵网络中，1表示单元格上有服务四，0表示没有，如果两台服务器位于同一行，或者同一列中紧邻的位置，则认为他们之间可以组或一个局域，请你统计机房中最大的局城网包含的服务口个数，
 * <p>
 * 【注意】：此处考虑的是[如果两台服务器位于同一行，或者同一列中紧邻的位置]
 * 本解法是基于 【注意leetcode】：此处考虑的是[如果两台服务器位于同一行或者同一列]，我们就认为它们之间可以进行通信。
 * - 输入描述，：
 * 第1行输入两个正整数，n和m,n大于0,m＜=100.
 * 之后为n*m得二维数组，，代表服务器信息，
 * <p>
 * - 输出
 * 最大局城网包含的服务器个数，
 * <p>
 * 输入
 * 22
 * 10
 * 11
 * 输出：
 * 3
 */
public class Huawei_20200603_05 {

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
            int count = countServers(grid);
            System.out.println(count);

        }

        //        int[][] grid = {{1, 0}, {1, 1}};
        //        int[][] grid = {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        //        int[][] grid = {{1, 0, 0, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}};
        //        int count = countServers(grid);
        //        System.out.println(count);
    }

    public static int countServers(int[][] grid) {
        //服务器的最大数量
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int temp = dfs(grid, i, j);
                    if (temp > 1) {
                        res += temp;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 深度优先遍历
     *
     * @param grid 矩阵
     * @param row  行
     * @param col  列
     * @return
     */
    private static int dfs(int[][] grid, int row, int col) {
        if (grid[row][col] == 0) {
            return 0;
        }
        //标识子节点已经遍历过了
        grid[row][col] = 0;
        // 每次调用的时候默认num为1，进入后判断如果不是岛屿，则直接返回0，就可以避免预防错误的情况。
        // 每次找到岛屿，则直接把找到的岛屿改成0，这是传说中的沉岛思想，就是遇到岛屿就把他和周围的全部沉默。
        // ps：如果能用沉岛思想，那么自然可以用朋友圈思想。有兴趣的朋友可以去尝试。
        int num = 1;

        //遍历行
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == 1) {
                num += dfs(grid, i, col);
            }
        }
        //遍历列
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[row][j] == 1) {
                num += dfs(grid, row, j);
            }
        }

        return num;
    }
}


