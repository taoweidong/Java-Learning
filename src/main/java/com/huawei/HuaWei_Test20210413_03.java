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
 * 42. 接雨水
 *
 * @author Taoweidong
 */
public class HuaWei_Test20210413_03 {

  public static void main(String[] args) {
    int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int result = new HuaWei_Test20210413_03().trap(height);
    System.out.println(result);
  }

  public int trap(int[] height) {
    //    输出结果
    int result = 0;
    //    特殊情况处理
    if (height == null || height.length == 0) {
      return result;
    }
    //    定义单调栈
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < height.length; i++) {
      while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
        int top = stack.pop();
        if (stack.isEmpty()) {
          break;
        }
        // 计算低洼处的宽度和高度
        // 宽度
        int width = i - stack.peek() - 1;
        // 计算高度
        int h = Math.min(height[i], height[stack.peek()]) - height[top];
        // 计算结果
        result += width * h;
      }
      stack.push(i);
    }
    return result;
  }
}
