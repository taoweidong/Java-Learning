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

import java.util.Arrays;
import java.util.Stack;

/**
 * 556. 下一个更大元素 III
 *
 * @author Taoweidong
 */
public class HuaWei_Test20210409_01 {

  public static void main(String[] args) {
    int result = new HuaWei_Test20210409_01().nextGreaterElement(12);
    System.out.println(result);
  }

  public int nextGreaterElement(int n) {
    String numStr = String.valueOf(n);
    int len = numStr.length();

    // 栈空间
    Stack<Integer> stack = new Stack<>();
    int memIdx = -1;
    long res = -1;

    // 遍历数组，进行单调处理
    for (int i = len - 1; i >= 0; i--) {
      while (!stack.isEmpty() && numStr.charAt(stack.peek()) > numStr.charAt(i)) {
        memIdx = stack.peek();
        stack.pop();
      }

      if (memIdx != -1) {}
    }

    return 0;
  }
}
