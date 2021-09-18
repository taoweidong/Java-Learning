package com.java8_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.java8.Employee;

/**
 * Stream的三步操作
 * 
 * @author Taowd
 * @version 2018年12月27日
 * @see StreamTest
 */
@SuppressWarnings("unused")
public class StreamTest {

    @Test
    public void test01() {

        // 1、可以通过Collection系列集合提供第二stream()或 parallelStream()
        List<String> list = new ArrayList<String>();
        Stream<String> stream1 = list.stream();

        // 2、通过Arrays中的静态方法stream()获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        // 3、通过stream类中的静态方法of()
        Stream<String> stream3 = Stream.of("aaa", "bbb");

        // 4、创建无无限流
        // 迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(100).forEach(System.out::println);

        // 生成
        Stream.generate(() -> Math.random())//
            .limit(10).forEach(System.out::println);

    }
}
