package com.leetcode;

import java.util.Stack;

/**
 * 962. 最大宽度坡:https://leetcode-cn.com/problems/maximum-width-ramp/
 */
public class HelloWorld_962 {
    public static void main(String[] args) {
        int[] input = {6, 0, 8, 2, 1, 5};
        System.out.println(new HelloWorld_962().maxWidthRamp(input));

    }

    public int maxWidthRamp(int[] A) {

        Stack<Integer> stack = new Stack<>();
        //排序
        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty() || A[stack.peek()] >= A[i]) {
                stack.add(i);
            }
        }

        int maxLength = Integer.MIN_VALUE;
        for (int i = A.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                maxLength = Math.max(maxLength, i - stack.pop());
            }

        }

        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }
}
