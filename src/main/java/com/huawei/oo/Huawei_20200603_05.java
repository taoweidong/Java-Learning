package com.huawei.oo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 按索引范围翻转文章片断， 辅入一个英文文章片段，翻转
 * 指定区间的单词顺序，标点符号和普通字母一样处理，
 * 副如输入守符串＂1 am a developer, ", 区间[0, 3] ,
 * 刚输仙 "developer a am 1"
 * Stimg reverse words (string s,int start,int end)
 * 输人描述：使用换行隔开三个参数，第一个参数的为英文文章风内容，即英文字符串，第二个下标未翻转起始单饲下标。
 * （下栋从0开始）， 第三个参数为结束单词下标，
 * 输出：
 * 翻转后的的英文文章片段所有单词之间以一个半角空格分隔输出
 * <p>
 * 输入
 * 1 am a developer.
 * 1
 * 2
 * 输出
 * 1 a am developer.
 */
public class Huawei_20200603_05 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//
//
//        }

//        int[][] grid = {{1, 0}, {1, 1}};
//        int[][] grid = {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        int[][] grid = {{1, 0, 0, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}};
        int count = countServers(grid);
        System.out.println(count);


    }

    public static int countServers(int[][] grid) {

        //服务器的最大数量
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int temp = dfs(grid, i, j);
                    if (temp != 1) {
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
     * @param grid
     * @param row
     * @param col
     * @return
     */
    private static int dfs(int[][] grid, int row, int col) {

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == 0) {
            return 0;
        }

        //标识子节点已经遍历过了
        grid[row][col] = 0;
        // 每次调用的时候默认num为1，进入后判断如果不是岛屿，则直接返回0，就可以避免预防错误的情况。
        // 每次找到岛屿，则直接把找到的岛屿改成0，这是传说中的沉岛思想，就是遇到岛屿就把他和周围的全部沉默。
        // ps：如果能用沉岛思想，那么自然可以用朋友圈思想。有兴趣的朋友可以去尝试。
        int num = 1;
//        num += dfs(grid, i - 1, j);
        num += dfs(grid, row + 1, col);
//        num += dfs(grid, i, j - 1);
        num += dfs(grid, row, col + 1);

        //遍历行
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][row] == 1) {
                dfs(grid, gridSize, gridColSize, i, col, num);
            }
        }
        //遍历列
        for (int j = 0; j < grid[row].length; j++) {
            if (grid[col][j] == 1) {
                dfs(grid, gridSize, gridColSize, row, j, num);
            }
        }

        return num;
    }
}


