package com.offer;

import java.util.Stack;

/**
 * 问题描述：后序遍历
 * 后序遍历（LRD）是二叉树遍历的一种，也叫做后根遍历、后序周游，可记做左右根。后序遍历有递归算法和非递归算法两种。在二叉树中，先左后右再根。巧记：左右根。
 * 后序遍历首先遍历左子树，然后遍历右子树，最后访问根结点，在遍历左、右子树时，仍然先遍历左子树，然后遍历右子树，最后遍历根结点。即：
 * 若二叉树为空则结束返回，
 * ————————————————
 * 版权声明：本文为CSDN博主「coder__666」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/coder__666/article/details/80349039
 * 算法核心思想：
 * 首先要搞清楚先序、中序、后序的非递归算法共同之处：用栈来保存先前走过的路径，以便可以在访问完子树后,可以利用栈中的信息,回退到当前节点的双亲节点,进行下一步操作。
 * 后序遍历的非递归算法是三种顺序中最复杂的，原因在于，后序遍历是先访问左、右子树,再访问根节点，而在非递归算法中，利用栈回退到时，并不知道是从左子树回退到根节点，还是从右子树回退到根节点，如果从左子树回退到根节点，此时就应该去访问右子树，而如果从右子树回退到根节点，此时就应该访问根节点。所以相比前序和后序，必须得在压栈时添加信息，以便在退栈时可以知道是从左子树返回，还是从右子树返回进而决定下一步的操作。
 * ————————————————
 * 版权声明：本文为CSDN博主「coder__666」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/coder__666/article/details/80349039
 *
 * @author Taoweidong
 */
public class HuaWeiTest_04 {
    public static void main(String[] args) {
        //以数组形式生成一棵完全二叉树
        TreeNode[] node = new TreeNode[10];
        for (int i = 0; i < 10; i++) {
            node[i] = new TreeNode(i);
        }
        for (int i = 0; i < 10; i++) {
            if (i * 2 + 1 < 10) {
                node[i].left = node[i * 2 + 1];
            }
            if (i * 2 + 2 < 10) {
                node[i].right = node[i * 2 + 2];
            }
        }

        postOrderRe(node[0]);
        System.out.println("***");
        postOrder(node[0]);


    }

    /**
     * 后序遍历
     *
     * @param tree
     */
    public static void postOrderRe(TreeNode tree) {
        if (tree == null) {
            return;
        } else {
            postOrderRe(tree.left);
            postOrderRe(tree.right);
            System.out.println(tree.value);
        }

    }

    /**
     * 后序遍历
     *
     * @param biTree
     */
    public static void postOrder(TreeNode biTree) {//后序遍历非递归实现
        int left = 1;//在辅助栈里表示左节点
        int right = 2;//在辅助栈里表示右节点
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> stack2 = new Stack<Integer>();//辅助栈，用来判断子节点返回父节点时处于左节点还是右节点。

        while (biTree != null || !stack.empty()) {
            while (biTree != null) {//将节点压入栈1，并在栈2将节点标记为左节点
                stack.push(biTree);
                stack2.push(left);
                biTree = biTree.left;
            }

            while (!stack.empty() && stack2.peek() == right) {//如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                stack2.pop();
                System.out.println(stack.pop().value);
            }

            if (!stack.empty() && stack2.peek() == left) {//如果是从左子节点返回父节点，则将标记改为右子节点
                stack2.pop();
                stack2.push(right);
                biTree = stack.peek().right;
            }

        }
    }


}


class TreeNode//节点结构
{
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
    }
}
