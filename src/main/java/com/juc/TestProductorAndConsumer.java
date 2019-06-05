package com.juc;

/**
 * 生成者消费者问题.
 */
public class TestProductorAndConsumer {

	public static void main(String[] args) {

		Clerk clerk = new Clerk();

		Productor productor = new Productor(clerk);
		Consumer consumer = new Consumer(clerk);

		new Thread(productor, "生产者A").start();
		new Thread(consumer, "消费者B").start();

	}
}

// 店员
class Clerk {

	// 共享变量：存在多线程安全问题
	private int product = 0;

	public synchronized void get() {

		// 2. 生产者获取线程 此时product=0
		if (product >= 1) {// product =0
			System.out.println("产品已满！");
			try {
				// 4 生产者抢到资源获取线程 此时product=1，线程等待，此时没有其他线程唤醒，形成死锁问题
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			// 生产商品
			// 3. 生产者获取线程 此时product=1，此时线程唤醒
			System.out.println(Thread.currentThread().getName() + "--->" + ++product);
			this.notifyAll();
		}

	}

	public synchronized void sale() {

		// 1. 消费者获取线程 此时product=0 循环次数为 0
		if (product <= 0) {
			System.out.println("缺货！");
			try {
				this.wait();// 2. 消费者获取线程 此时product=1 此时线程等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(Thread.currentThread().getName() + "---->" + --product);
			this.notifyAll();
		}
		// 4 消费者抢到资源获取线程 此时product=1，继续执行
	}
}

// 生产者
class Productor implements Runnable {

	private Clerk clerk;

	public Productor(Clerk clerk) {

		this.clerk = clerk;
	}

	@Override
	public void run() {

		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.get();
		}

	}
}

// 消费者
class Consumer implements Runnable {

	private Clerk clerk;

	public Consumer(Clerk clerk) {

		this.clerk = clerk;
	}

	@Override
	public void run() {

		for (int i = 0; i < 20; i++) {
			clerk.sale();
		}
	}
}
