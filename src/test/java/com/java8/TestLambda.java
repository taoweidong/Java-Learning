package com.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class TestLambda {

    List<Employee> emps = Arrays.asList(//
        new Employee(101, "张三", 15, 2225.22), //
        new Employee(102, "王五", 34, 6666.22), //
        new Employee(103, "马六", 45, 8888.22), //
        new Employee(104, "诸葛小坏", 78, 3455.22), //
        new Employee(105, "李四", 24, 8966.89));

    @Test
    public void test01() {
        Collections.sort(emps, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        emps.forEach(System.out::println);

    }

    @Test
    public void test02() {

        op(100L, 200L, (x, y) -> x + y);

        op(100L, 200L, (x, y) -> x * y);
    }

    public void op(Long l1, Long l2, MyFunction<Long, Long> mf) {
        System.out.println(mf.getValue(l1, l2));
    }

}
