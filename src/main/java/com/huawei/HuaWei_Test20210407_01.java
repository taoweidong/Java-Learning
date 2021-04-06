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

import java.util.*;

/**
 * 题目：有两个数组a，b，大小都为n，数组元素的值任意，无序； 要求： 通过交换a，b中的元素，使数组a元素的和与数组b元素的和之间的差最小。
 * https://blog.csdn.net/wentaox/article/details/72792726?depth_1-utm_source=distribute.pc_relevant.none-task-blog-OPENSEARCH-1&utm_source=distribute.pc_relevant.none-task-blog-OPENSEARCH-1
 *
 * @author Taoweidong
 */
public class HuaWei_Test20210407_01 {

  public static void main(String[] args) {
    int[] nums1 = {4, 1, 2};
    int[] nums2 = {1, 3, 4, 2};
    int[] result = new HuaWei_Test20210407_01().nextGreaterElement(nums1, nums2);
    System.out.println(Arrays.toString(result));
  }

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {

    Map<Integer, Integer> map = new HashMap<>(nums2.length);

    Stack<Integer> stack = new Stack<>();

    for (int i = nums2.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
        stack.pop();
      }

      map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
      stack.push(nums2[i]);
    }

    for (int i = 0; i < nums1.length; i++) {
      nums1[i] = map.get(nums1[i]);
    }

    return nums1;
  }
}
