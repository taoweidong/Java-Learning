package com.java8;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Java8日期格式学习<br>
 * 这是一个线程不安全的示例
 * 
 * @author taowd
 * @version 2019年4月27日
 * @see DateDemo
 */
public class DateDemo {

    public static void main(String[] args) {

        // System.out.println(LocalDate.now());
        // System.out.println(LocalDateTime.now());
        // System.out.println(LocalTime.now());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Callable<Date> task = new Callable<Date>() {

            @Override
            public Date call() throws Exception {

                return simpleDateFormat.parse("2019-04-25");
            }

        };

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<Date>> results = new ArrayList<>();

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

        // results.forEach(x -> {
        // try {
        // System.out.println(x.get());
        // } catch (InterruptedException | ExecutionException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // });

        pool.shutdown();

    }

}
