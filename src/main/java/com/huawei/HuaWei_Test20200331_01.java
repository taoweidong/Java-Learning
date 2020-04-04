package com.huawei;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 优先级队列问题
 * 输入：A1,B2,C3,a9,d0
 * 输出：a9,C3,B2,A1,d0
 * @author Taoweidong
 */
public class HuaWei_Test20200331_01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			//输入参数
			String[] input = sc.nextLine().split(",");

			//组织数据，处理结果
			PriorityQueue<Temp> priorityQueue = new PriorityQueue<>((x, y) -> y.s - x.s);
			for (String item : input) {
				char[] t = item.toCharArray();
				Temp temp = new Temp();
				temp.f = t[0];
				temp.s = t[1];
				priorityQueue.add(temp);
			}

			//输出结果
			while (!priorityQueue.isEmpty()) {
				Temp tt;
				if (priorityQueue.size() == 1) {
					tt = priorityQueue.poll();
					System.out.print(tt.f.toString() + tt.s.toString());
				} else {
					tt = priorityQueue.poll();
					System.out.print(tt.f.toString() + tt.s.toString() + ",");
				}
			}

		}
	}

}

class Temp {

	/**
	 * 第一个字符
	 */
	public Character f;

	/**
	 * 第二个字符
	 */
	public Character s;

}
