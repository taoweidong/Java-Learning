package com.data.structure;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		//总钱数
		int n = Integer.parseInt(str.split(" ")[0]);
		//希望购买物品的个数
		int m = Integer.parseInt(str.split(" ")[1]);

		Good[] goods = new Good[m];
		for (int i = 0; i < m; i++) {
			String[] strings = sc.nextLine().split(" ");
			Good good = new Good(i + 1, Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
			//主件标志
			int temp = Integer.parseInt(strings[2]);
			if (temp != 0 && goods[temp - 1] != null) {
				goods[temp - 1].addQ(good);
				continue;
			}

			goods[i] = good;
		}

		for (Good item : goods) {
			System.out.println(item);
		}

	}
}

class Good {

	/**
	 * 商品编号
	 */
	public int no;

	/**
	 * 商品的价格
	 */
	public int v;

	/**
	 * 重要程度
	 */
	public int p;

	public void addQ(Good q) {

		this.q.add(q);
		//修改这个商品的权重值
		this.total = this.total + (q.v * q.p);
	}

	/**
	 * 附件列表
	 */
	public List<Good> q = new ArrayList<>();

	/**
	 * 当前商品的价格和重要度的乘积，如果包含附件，也计算附件的值
	 */
	public int total;

	public Good(int no, int v, int p) {

		this.no = no;
		this.v = v;
		this.p = p;

		this.total = this.v * this.p;
	}

	@Override public String toString() {

		return JSON.toJSONString(this);
	}
}

