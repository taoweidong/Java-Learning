package com.huawei.oo;

import java.util.Scanner;

/**
 * # 【服务器问题】--注意leetCode上的题意和复习题不一致
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 * 【如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信】。
 * 【请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量】。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-servers-that-communicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入：grid = [[1,0],[0,1]]
 * 输出：0
 * 解释：没有一台服务器能与其他服务器进行通信。
 * 输入：grid = [[1,0],[1,1]]
 * 输出：3
 * 解释：所有这些服务器都至少可以与一台别的服务器进行通信。
 * 输入：grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
 * 输出：4
 * 解释：第一行的两台服务器互相通信，第三列的两台服务器互相通信，但右下角的服务器无法与其他服务器通信。
 * <p>
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


