package com.data.structure;

import java.util.Scanner;

/**
 * @author Taoweidong
 */
public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		Goods[][] goodsArr = new Goods[m + 1][3];
		for (int i = 1; i <= m; i++) {
			int v = in.nextInt();
			int p = in.nextInt();
			int q = in.nextInt();
			Goods t = new Goods(v, p);
			if (q == 0) {
				goodsArr[i][0] = t;
			} else {
				if (goodsArr[q][1] == null) {
					goodsArr[q][1] = t;
				} else {
					goodsArr[q][2] = t;
				}
			}
		}
		int[] arr = new int[n + 1];
		int max = 0;
		int weight = 0;
		for (int i = 1; i <= m; i++) {
			Goods goods = goodsArr[i][0];
			for (int j = n; goods != null && j >= 0; j--) {
				max = arr[j];
				if (j >= goods.v && max < arr[j - goods.v] + goods.vp) {
					max = arr[j - goods.v] + goods.vp;
				}
				if (goodsArr[i][1] != null) {
					if (j >= (weight = goods.v + goodsArr[i][1].v)
							&& max < arr[j - weight] + goods.vp + goodsArr[i][1].vp) {
						max = arr[j - weight] + goods.vp + goodsArr[i][1].vp;
					}
				}
				if (goodsArr[i][2] != null) {
					if (j >= (weight = goods.v + goodsArr[i][1].v + goodsArr[i][2].v) && max
							< arr[j - weight] + goods.vp + goodsArr[i][1].vp + goodsArr[i][2].vp) {
						max = arr[j - weight] + goods.vp + goodsArr[i][1].vp + goodsArr[i][2].vp;
					} else if (j >= (weight = goods.v + goodsArr[i][2].v)
							&& max < arr[j - weight] + goods.vp + goodsArr[i][2].vp) {
						max = arr[j - weight] + goods.vp + goodsArr[i][2].vp;
					}
				}
				arr[j] = max;
			}
		}
		System.out.println(arr[n]);
	}
}

class Goods {

	int v;

	int vp;

	public Goods(int v, int p) {

		this.v = v;
		this.vp = v * p;
	}
}