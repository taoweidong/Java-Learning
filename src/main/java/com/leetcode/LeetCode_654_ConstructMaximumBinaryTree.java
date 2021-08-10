package com.leetcode;

import java.util.Objects;

public class LeetCode_654_ConstructMaximumBinaryTree {
    public static void main(String[] args) {

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (Objects.isNull(nums)) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return construct(nums, 0, nums.length - 1);

    }

    private TreeNode construct(int[] nums, int left, int right) {
        if (left > right) {
            // 递归结束条件
            return null;
        }
        // 找到数组的最大值以及索引
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = left; i <= right; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        // 构造二叉树
        TreeNode root = new TreeNode(maxValue);
        root.left = construct(nums, left, maxIndex - 1);
        root.right = construct(nums, maxIndex + 1, right);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
