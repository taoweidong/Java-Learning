package com.juc;

/**
 * 多线程学习-volatile关键字<br>
 * 内存可见性（Memory Visibility）是指当某个线程正在使用对象状态
 * 而另一个线程在同时修改该状态，需要确保当一个线程修改了对象
 * 状态后，其他线程能够看到发生的状态变化。
 * @author taowd
 * @version 2019年4月28日
 * @see ThreadDemo
 */
public class ThreadDemo {

	public static void main(String[] args) {

		// 写操作
		ThreadDemo1 td = new ThreadDemo1();
		new Thread(td).start();

		// 读操作
		while (true) {
			if (td.isFlag()) {
				System.out.println("---------------------");
				break;
			}
		}

		// 发生了内存可见性问题：两个线程在操作同一共享数据时，彼此之间不可见的问题
	}

}

class ThreadDemo1 implements Runnable {

	private volatile boolean flag = false;

	public boolean isFlag() {

		return flag;
	}

	public void setFlag(boolean flag) {

		this.flag = flag;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		flag = true;

		System.out.println("flag=" + isFlag());

	}

}
