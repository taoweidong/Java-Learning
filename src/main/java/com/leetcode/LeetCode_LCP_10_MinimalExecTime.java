package com.leetcode;

import java.util.Objects;

public class LeetCode_LCP_10_MinimalExecTime {
    public static void main(String[] args) {

    }

    public double minimalExecTime(TreeNode root) {
        double result = root.val;
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return result;
        }

        double temp = 0;
        if (Objects.isNull(root.left)) {
            return result + minimalExecTime(root.right);
        } else if (Objects.isNull(root.right)) {
            return result + minimalExecTime(root.left);
        } else {
            double leftTime = minimalExecTime(root.left);
            double rightTime = minimalExecTime(root.right);

            temp = helper(root);
            temp = (temp - root.val) / 2;
            temp = Math.max(temp, leftTime);
            temp = Math.max(temp, rightTime);

        }
        return result + temp;
    }

    private double helper(TreeNode root) {
        double result = 0;
        if (root == null) {
            return result;
        } else {
            result = root.val;
            result += helper(root.left);
            result += helper(root.right);
        }

        return result;
    }
}
