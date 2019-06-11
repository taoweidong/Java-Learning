package com.juc;

/**
 * 题目：判断输出结果，分析多线程锁的概念</br>
 * 1. 两个普通同步方法，两个线程，标准打印， 打印? //one two
 * 2. 新增 Thread.sleep() 给 getOne() ,打印? //one two
 * 3. 新增普通方法 getThree() , 打印? //three one two
 * 4. 两个普通同步方法，两个 Number 对象，打印? //two one
 * 5. 修改 getOne() 为静态同步方法，打印? //two one
 * 6. 修改两个方法均为静态同步方法，一个 Number 对象? //one two
 * 7. 一个静态同步方法，一个非静态同步方法，两个 Number 对象? //two one
 * 8. 两个静态同步方法，两个 Number 对象? //one two
 */
public class TestThread8Monitor {

	public static void main(String[] args) {

		Number number = new Number();
		Number number2 = new Number();

		new Thread(new Runnable() {

			@Override
			public void run() {

				number.getOne();
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {

				number2.getTwo();
			}
		}).start();

	}
}

class Number {

	public static synchronized void getOne() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("one");
	}

	public static synchronized void getTwo() {

		System.out.println("two");
	}

}
