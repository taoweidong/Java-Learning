package com.leetcode;

import java.util.Objects;

/**
 * 112. 路径总和
 */
public class LeetCode_112_HasPathSum {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (Objects.isNull(root)) {
            return false;
        }
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    // private boolean hashPath(TreeNode root, Integer s, int targetSum) {
    // if (Objects.isNull(root)) {
    // return false;
    // }
    //
    // s += root.val;
    // if (s == targetSum) {
    // return true;
    // }
    //
    // return false;
    // }
}
