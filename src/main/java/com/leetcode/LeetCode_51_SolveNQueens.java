package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * 51. N 皇后: https://leetcode-cn.com/problems/n-queens/
 */
public class LeetCode_51_SolveNQueens {
    public static void main(String[] args) {
        List<List<String>> result = new LeetCode_51_SolveNQueens().solveNQueens(4);
        // System.out.println(result);
        result.stream().forEach(x -> System.out.println(JSON.toJSONString(x)));

    }

    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        result = new LinkedList<>();
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        backtrack(n, 0, board);
        return result;
    }

    private void backtrack(int n, int row, char[][] board) {
        if (row == board.length) {
            // 回溯退出条件
            List<String> copyBoard = new ArrayList<>();
            for (char[] chars : board) {
                copyBoard.add(String.valueOf(chars));
            }
            result.add(copyBoard);
            return;
        }

        // 遍历每一个棋子位
        for (int col = 0; col < n; col++) {
            // 判断棋子位是否合法
            if (!isValid(board, n, row, col)) {
                continue;
            }
            // 回溯
            board[row][col] = 'Q';
            backtrack(n, row + 1, board);
            // 推出
            board[row][col] = '.';
        }

    }

    private boolean isValid(char[][] board, int n, int row, int col) {
        // 判断列中是否包含皇后
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 判断右上方(斜线)是否存在皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 判断左上方(斜线)是否存在皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 说明皇后落子合格
        return true;
    }

}
