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
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 *
 * @author Taoweidong
 */
public class HuaWei_Test20210408_01 {

  public static void main(String[] args) {
    int[] nums1 = {4, 1, 2};
    int[] nums2 = {1, 3, 4, 2};
    int[] result = new HuaWei_Test20210408_01().nextGreaterElement(nums2);
    System.out.println(Arrays.toString(result));
  }

  public int[] nextGreaterElement(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    // 初始化数组
    Arrays.fill(result, -1);
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n * 2 - 1; i++) {
      while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
        result[stack.pop()] = nums[i % n];
      }
      stack.push(i % n);
    }
    return result;
  }
}
