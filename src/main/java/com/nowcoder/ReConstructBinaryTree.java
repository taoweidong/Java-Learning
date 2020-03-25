package com.nowcoder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Taowd
 * @Description 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 */
public class ReConstructBinaryTree {

	/**
	 * 内部类  二叉树结构
	 */
	//Definition for binary tree
	public class TreeNode {

		int val;

		TreeNode left;

		TreeNode right;

		TreeNode(int x) {

			val = x;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		TreeNode treeNode = new ReConstructBinaryTree().reConstructBinaryTree(pre, in);

		PrintTree(treeNode);

		// System.out.println(treeNode.val);

	}

	/**
	 * 打印二叉树
	 * @param treeNode
	 */
	public static void PrintTree(TreeNode treeNode) {
		//创建一个队列用来存放节点
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		//当前节点的最右节点
		TreeNode last;
		//下一行打印的最右节点
		TreeNode nlast = null;
		last = treeNode;
		//先将根放入队列中
		queue.add(treeNode);
		//队列不为空时，就一直循环poll直到队列为空
		while (queue.size() > 0) {
			//推出节点
			TreeNode nowTree = queue.poll();
			//如果当前节点有左节点，将左节点压入队列中
			if (nowTree.left != null) {
				queue.add(nowTree.left);
				nlast = nowTree.right;
			}
			//如果当前节点有右节点，将右节点压入队列中
			if (nowTree.right != null) {
				queue.add(nowTree.right);
				nlast = nowTree.right;
			}
			System.out.print("" + nowTree.val);
			//当前打印节点为当前行最右节点时换行
			if (last != null && last.equals(nowTree)) {
				System.out.println();
				last = nlast;
			}
		}
	}

	/**
	 * @param pre 前序遍历
	 * @param in  中序遍历
	 * @return 二叉树结构
	 */
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

		if (pre.length == 0 || in.length == 0) {
			return null;
		}
		TreeNode node = new TreeNode(pre[0]);
		for (int i = 0; i < in.length; i++) {

			if (pre[0] == in[i]) {
				node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1),
						Arrays.copyOfRange(in, 0, i));
				node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
						Arrays.copyOfRange(in, i + 1, in.length));
				break;
			}
		}
		return node;
	}

}




