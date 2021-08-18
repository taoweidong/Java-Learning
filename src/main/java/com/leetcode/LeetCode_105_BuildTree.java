package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_105_BuildTree {
    public static void main(String[] args) {

    }

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inoLeft, int inoRight) {
        if (preLeft > preRight) {
            return null;
        }

        int root = preorder[preLeft];
        int rootIndex = map.get(root);

        int leftLength = rootIndex - inoLeft;

        TreeNode rootNode = new TreeNode(root);
        rootNode.left = build(preorder, inorder, preLeft + 1, preLeft + leftLength, inoLeft, rootIndex - 1);
        rootNode.right = build(preorder, inorder, preLeft + leftLength + 1, preRight, rootIndex + 1, inoRight);

        return rootNode;
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
