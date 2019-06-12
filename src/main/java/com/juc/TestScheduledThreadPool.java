package com.juc;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 线程池调度
 */
public class TestScheduledThreadPool {

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);

		for (int i = 0; i < 10; i++) {
			Future<Integer> future = pool.schedule(new Callable<Integer>() {

				@Override
				public Integer call() {

					int number = new Random().nextInt(100);// 生成随机数
					System.out.println(Thread.currentThread().getName() + " : "
							+ LocalDateTime.now() + "--->" + number);
					return number;
				}
			}, 3, TimeUnit.SECONDS); // 定时每隔三秒执行一次，线程调度

			System.out.println(future.get());
		}

		pool.shutdown();

	}
}
