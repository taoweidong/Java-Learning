package com.leetcode;

import java.util.Objects;

/**
 * 101. 对称二叉树：给定一个二叉树，检查它是否是镜像对称的
 */
public class LeetCode_101_IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (Objects.isNull(left) && Objects.isNull(right)) {
            return true;
        }
        if (Objects.isNull(left) || Objects.isNull(right)) {
            return false;
        }

        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }
}
