//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
//网格的四个边均被水包围。 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集

package com.leetcode;

/**
 * 岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
 * 网格的四个边均被水包围。
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * @author Taoweidong
 */
public class NumberOfIslands {

	public static void main(String[] args) {

		Solution solution = new NumberOfIslands().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		public int numIslands(char[][] grid) {

			if (grid == null || grid.length == 0) {
				return 0;
			}

			//行
			int col = grid.length;
			//列
			int row = grid[0].length;

			//小岛的个数
			int num_islands = 0;

			for (int i = 0; i < col; i++) {
				for (int j = 0; j < row; j++) {
					if (grid[i][j] == '1') {
						//增加小岛个数
						++num_islands;
						dfs(grid, i, j);
					}
				}
			}

			return num_islands;
		}

		/**
		 * 深度优先遍历-遍历所有的子节点
		 * @param grid 邻接矩阵
		 * @param i    行
		 * @param j    列
		 */
		private void dfs(char[][] grid, int i, int j) {
			//行
			int col = grid.length;
			//列
			int row = grid[0].length;
			//遍历结束或者已经遍历过，就无需再次进行遍历
			if (i < 0 || j < 0 || i >= col || j >= row || grid[i][j] == '0') {
				return;
			}

			//标志当前已经被遍历过了
			grid[i][j] = '0';
			//上下左右方向全部遍历一次
			dfs(grid, i - 1, j);
			dfs(grid, i + 1, j);
			dfs(grid, i, j - 1);
			dfs(grid, i, j + 1);
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}