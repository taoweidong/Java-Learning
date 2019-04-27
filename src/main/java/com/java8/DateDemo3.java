package com.java8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Java8日期格式学习<br>
 * jdk1.8的示例
 * @author taowd
 * @version 2019年4月27日
 * @see DateDemo3
 */
public class DateDemo3 {

	public static void main(String[] args) {

		// System.out.println(LocalDate.now());
		// System.out.println(LocalDateTime.now());
		// System.out.println(LocalTime.now());

		Callable<LocalDate> task = new Callable<LocalDate>() {

			@Override
			public LocalDate call() throws Exception {

				return LocalDate.parse("2019-04-26", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			}

		};

		ExecutorService pool = Executors.newFixedThreadPool(10);

		List<Future<LocalDate>> results = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			results.add(pool.submit(task));
		}

		for (int i = 0; i < results.size(); i++) {
			try {
				System.out.println(results.get(i).get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		pool.shutdown();

	}

}
