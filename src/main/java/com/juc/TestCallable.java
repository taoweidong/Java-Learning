package com.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现线程的第三种方式：实现Callable接口
 */
public class TestCallable {

	public static void main(String[] args) {

		ThreadDemo222 t = new ThreadDemo222();

		FutureTask futureTask = new FutureTask(t);
		new Thread(futureTask).start();

		// FutureTasK也可以用于闭锁

		System.out.println("------------------------------------------");

		try {
			System.out.println(futureTask.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}
}

class ThreadDemo222 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {

		int sum = 0;
		for (int i = 0; i <= 1000000; i++) {
			System.out.println(i);
			sum += i;
		}

		return sum;
	}
}
