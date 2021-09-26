package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I：单调栈的考点
 */
public class LeetCode_496_NextGreaterElement {
    public static void main(String[] args) {
        // int[] nums1 = {4, 1, 2};
        // int[] nums2 = {1, 3, 4, 2};

        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};

        int[] result = new LeetCode_496_NextGreaterElement().nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result));

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        // 1, 3, 4, 2
        // 单调递增
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        // 单调递减
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}
