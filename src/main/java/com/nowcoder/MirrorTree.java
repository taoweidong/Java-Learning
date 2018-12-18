package com.nowcoder;

/**
 * @ClassName MirrorTree
 * @Description 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @Author Taowd
 * @Date 2018/6/4 21:52
 * @Version V1.0
 */
public class MirrorTree {

    /**
     * 二叉树结构
     */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static void main(String[] args) {

    }

    /**
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     *
     * @param root
     */
    public static void Mirror(TreeNode root) {
        TreeNode temp = null;
        if (root != null) {
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            if (root.left != null) {
                Mirror(root.left);
            }
            if (root.right != null) {
                Mirror(root.right);
            }
        }
    }
}
