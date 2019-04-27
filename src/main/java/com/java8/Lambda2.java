package com.java8;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Taowd
 * @date 2018年12月19日 <br/>
 *       左侧：参数列表<br/>
 *       右侧：方法的具体实现,所执行的具体功能<br/>
 */
@SuppressWarnings("unused")
public class Lambda2 {

	public static void main(String[] args) {

		// 匿名内部类

		Runnable r1 = new Runnable() {

			@Override
			public void run() {

				// System.out.println("Test");
			}
		};

		// Lambda表达式
		Runnable r2 = () -> System.out.println("Test");

		// 原来的使用匿名内部类作为参数传递
		TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				// TODO Auto-generated method stub
				return Integer.compare(o1.length(), o2.length());
			}
		});

		// Lambda表达式作为参数传递
		TreeSet<String> ts2 = new TreeSet<>((o1, o2) -> Integer.compare(o1.length(), o2.length()));

		String result = new Lambda2().toUpper(() -> {
			return 12;
		}, "Hello World!");
		System.out.println(result);

	}

	public String toUpper(MyNumber my, String str) {

		return my.getValue() + str;
	}

}
