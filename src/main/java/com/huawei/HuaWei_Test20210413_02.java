// 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
// 网格的四个边均被水包围。
//
// 示例 1:
//
// 输入:
// 11110
// 11010
// 11000
// 00000
//
// 输出: 1
//
//
// 示例 2:
//
// 输入:
// 11000
// 11000
// 00100
// 00011
//
// 输出: 3
//
// Related Topics 深度优先搜索 广度优先搜索 并查集

package com.huawei;

import java.util.Stack;

/**
 * 657. 机器人能否返回原点. https://leetcode-cn.com/problems/robot-return-to-origin/
 *
 * @author Taoweidong
 */
public class HuaWei_Test20210413_02 {

  public static void main(String[] args) {
    boolean result = new HuaWei_Test20210413_02().judgeCircle("LL");
    System.out.println(result);
  }

  public boolean judgeCircle(String moves) {
    int x = 0, y = 0;
    int length = moves.length();
    for (int i = 0; i < length; i++) {
      char move = moves.charAt(i);
      if (move == 'U') {
        y++;
      } else if (move == 'D') {
        y--;
      } else if (move == 'L') {
        x--;
      } else if (move == 'R') {
        x++;
      }
    }
    return x == 0 && y == 0;
  }
}
