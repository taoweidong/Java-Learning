package com.java8;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Java8日期格式学习<br>
 * 经过处理，线程安全的示例
 * 
 * @author taowd
 * @version 2019年4月27日
 * @see DateDemo2
 */
public class DateDemo2 {

    public static void main(String[] args) {

        // System.out.println(LocalDate.now());
        // System.out.println(LocalDateTime.now());
        // System.out.println(LocalTime.now());

        Callable<Date> task = new Callable<Date>() {

            @Override
            public Date call() throws Exception {

                return DateFormatThreadLocal.convert("2019-04-26");
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
