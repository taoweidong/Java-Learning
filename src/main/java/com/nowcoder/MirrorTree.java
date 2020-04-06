package com.nowcoder;

/**
 * @ClassName MirrorTree
 * @Description 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @Author Taowd
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
    public static void mirror(TreeNode root) {

        TreeNode temp = null;
        if (root != null) {
            //交换当前节点的左右子树
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            if (root.left != null) {
                mirror(root.left);
            }
            if (root.right != null) {
                mirror(root.right);
            }
        }


    }
}
