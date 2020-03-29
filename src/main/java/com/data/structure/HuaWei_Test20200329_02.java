package com.data.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * java编程 输入任意的数（不超过1000000）
 * 将其分解成两个质数相加的形式，
 * 输出总共有多少总分解方式，分解因子不区分排序
 * example
 * input 100
 * 俩质数相加=100
 * 100=3+97
 * 100=11+89
 * 100=17+83
 * 100=29+71
 * 100=41+59
 * 100=47+53
 * output 6
 * ————————————————
 * 版权声明：本文为CSDN博主「我阳某人的博客」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_43278942/article/details/102696846
 * @author Taoweidong
 */
public class HuaWei_Test20200329_02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			//输入参数
			int input = sc.nextInt();

			//质数的集合
			List<Integer> list = new ArrayList<>();
			for (int i = 2; i < input; i++) {
				if (isPrime(i)) {
					list.add(i);
				}
			}

			//检查那两个质数相加满足条件
			int count = 0;
			for (int i = 0; i < list.size(); i++) {
				for (int j = i + 1; j < list.size(); j++) {
					if (list.get(i) != 0 && list.get(j) != 0) {
						if (list.get(i) + list.get(j) == input) {
							count++;
							list.set(i, 0);
							list.set(j, 0);
						}
					}
				}
			}

			System.out.println(count);

		}
	}

	/**
	 * 判断当前数字是否为质数:除了1和它本身外，不能被其他自然数整除的数叫做质数
	 * @param num 待判断数字
	 * @return True:质数 Flase:非质数
	 */
	public static boolean isPrime(int num) {

		//特殊的质数
		if (num == 2 || num == 3) {
			return true;
		}

		//优化：质数都是满足6X+1或者6x-1
		if (num % 6 == 1 || num % 6 == 5) {
			return true;
		}

		//其他判断
		int sqrt = (int) Math.sqrt(num);
		for (int i = 2; i <= sqrt; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
