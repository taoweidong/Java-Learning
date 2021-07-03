package com.leetcode;

public class LeetCode_84_LargestRectangleArea {
  public static void main(String[] args) {
    //
  }

  public int largestRectangleArea(int[] heights) {
    int len = heights.length;
    if (len == 0) {
      return 0;
    }

    int result = 0;
    for (int i = 0; i < len; i++) {
      //      找到左边最后一个大于等于height[i]的下标
      int left = i;
      int currentHeight = heights[i];
      while (left > 0 && heights[left - 1] >= currentHeight) {
        left--;
      }

      // 找到右边最后一个大于等于height[i]的下标
      int right = i;
      while (right < len - 1 && heights[right + 1] >= currentHeight) {
        right++;
      }

      int width = right - left + 1;
      result = Math.max(result, width * currentHeight);
    }

    return result;
  }
}
