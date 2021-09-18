package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode_739_DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(new LeetCode_739_DailyTemperatures().dailyTemperatures(temperatures)));
    }

    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                // 取出栈顶元素，计算栈顶元素到下一个比它更高的元素之间的距离
                int top = stack.pop();
                result[top] = i - top;
            }
            stack.push(i);
        }
        return result;
    }

    public int[] dailyTemperatures2(int[] T) {
        int[] result = new int[T.length];
        if (T == null || T.length == 0) {
            return result;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                // 取出栈顶元素，计算栈顶元素到下一个比它更高的元素之间的距离
                stack.pop();
            }
            // 如果是倒序的话，栈顶元素应该在当前遍历元素的后面
            result[i] = stack.isEmpty() ? -1 : (stack.peek() - i);
            stack.push(i);
        }
        return result;
    }
}
