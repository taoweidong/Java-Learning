package com.leetcode;

import java.util.Stack;

/**
 * 962. 最大宽度坡:https://leetcode-cn.com/problems/maximum-width-ramp/
 *
 * @author Taoweidong
 */
public class LeetCode_962_MaxWidthRamp {
    public static void main(String[] args) {
        int[] input = {6, 0, 8, 2, 1, 5};
        System.out.println(new LeetCode_962_MaxWidthRamp().maxWidthRamp(input));

    }

    /**
     * 求最大坡宽度
     *
     * @param A
     *            坡信息
     * @return 最大坡宽度
     */
    public int maxWidthRamp(int[] A) {

        Stack<Integer> stack = new Stack<>();
        // 排序
        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty() || A[stack.peek()] >= A[i]) {
                stack.add(i);
            }
        }

        System.out.println(stack);

        int maxLength = Integer.MIN_VALUE;
        for (int i = A.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                maxLength = Math.max(maxLength, i - stack.pop());
            }

        }

        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }
}
