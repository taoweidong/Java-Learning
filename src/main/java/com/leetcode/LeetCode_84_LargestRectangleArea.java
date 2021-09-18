package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode_84_LargestRectangleArea {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(new LeetCode_84_LargestRectangleArea().largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        // 存放结果
        int result = 0;

        // 构造新数组，处理左右边界问题
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        System.arraycopy(heights, 0, newHeights, 1, heights.length);

        // 单调递增栈
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < newHeights.length; i++) {
            // 单调递增栈
            while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
                // 入栈元素小于栈顶元素时进行出栈计算面积操作

                // 栈顶元素
                int h = newHeights[stack.pop()];
                int left = stack.peek();
                int w = i - left - 1;
                result = Math.max(result, w * h);
            }

            stack.push(i);
        }

        return result;
    }

    public int largestRectangleArea3(int[] heights) {
        // 存放结果
        int result = 0;
        if (heights.length == 0) {
            return result;
        }

        int len = heights.length;
        for (int i = 0; i < len; i++) {
            // 当前节点
            int current = heights[i];

            // 左区间
            int left = i;
            while (left > 0 && heights[left - 1] >= current) {
                left--;
            }

            // 右区间
            int right = i;
            while (right < len - 1 && heights[right + 1] >= current) {
                right++;
            }

            int width = right - left + 1;
            result = Math.max(result, width * current);
        }

        return result;
    }

    public int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            // 找到左边最后一个大于等于height[i]的下标
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
