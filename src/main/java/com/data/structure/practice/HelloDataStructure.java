package com.data.structure.practice;

/**
 * 算法学习-稀疏数组
 * @author Taoweidong
 */
public class HelloDataStructure {

	public static void main(String[] args) {

		int[][] chessArr = new int[11][11];
		chessArr[1][3] = 2;
		chessArr[2][5] = 8;
		// 打印二维数组
		for (int[] ints : chessArr) {
			for (int anInt : ints) {
				System.out.print(anInt + "\t\t\t");
			}
			System.out.println();
		}

		// 将二维数组转为稀疏数组
		// 1、遍历二维数组得到非0数字的个数
		int sum = 0;
		for (int i = 0; i < chessArr.length; i++) {
			for (int j = 0; j < chessArr[0].length; j++) {
				if (chessArr[i][j] != 0) {
					sum++;
				}
			}
		}
		System.out.println(sum);

		// 2、创建对应的稀疏数组
		int[][] sparseArr = new int[sum + 1][3];
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = sum;
		// 遍历
		int index = 1;
		for (int i = 0; i < chessArr.length; i++) {
			for (int j = 0; j < chessArr[i].length; j++) {
				if (chessArr[i][j] != 0) {
					sparseArr[index][0] = i;
					sparseArr[index][1] = j;
					sparseArr[index][2] = chessArr[i][j];
					index++;
				}
				System.out.print(chessArr[i][j] + "\t\t\t");
			}
			System.out.println();
		}

		// 遍历稀疏数组
		System.out.println("************遍历稀疏数组*****************");
		for (int i = 0; i < sparseArr.length; i++) {
			for (int j = 0; j < sparseArr[i].length; j++) {
				System.out.print(sparseArr[i][j] + "\t\t\t");
			}
			System.out.println();
		}

		// 稀疏数组--转为二维数组
		System.out.println("************稀疏数组--转为二维数组*****************");
		int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
		for (int i = 1; i < sparseArr.length; i++) {
			chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}

		for (int i = 0; i < chessArr2.length; i++) {
			for (int j = 0; j < chessArr2[i].length; j++) {
				System.out.print(chessArr2[i][j] + "\t\t\t");
			}
			System.out.println();
		}

	}
}
