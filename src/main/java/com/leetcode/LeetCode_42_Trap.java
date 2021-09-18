package com.leetcode;

import java.util.Stack;

public class LeetCode_42_Trap {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new LeetCode_42_Trap().trap(height));

        // int[] height = {4,2,0,3,2,5};
        // System.out.println(new LeetCode_42_Trap().trap(height));
        //
        // int[] height = {5};
        // System.out.println(new LeetCode_42_Trap().trap(height));
    }

    public int trap(int[] height) {
        int result = 0;
        if (height == null || height.length == 0) {
            return result;
        }
        Stack<Integer> stack = new Stack<>();
        // 遍历整个数组
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                // 把栈顶元素取出来
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                // 计算取出的栈顶元素top和两边较高的元素之间形成的低洼地区的面积
                // 计算宽度
                int w = i - stack.peek() - 1;
                // 计算高度
                int h = Math.min(height[i], height[stack.peek()]) - height[top];
                // 计算最终面积
                result += w * h;
            }
            stack.push(i);
        }
        return result;
    }
}
