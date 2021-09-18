package com.java8;

import java.util.Comparator;
import java.util.function.Consumer;

import org.junit.Test;

public class TestLambda2 {

    /**
     * Lambda语法格式1：无参数 无返回值
     */
    @Test
    public void test01() {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        };
        r1.run();

        System.out.println("----------------");

        Runnable r2 = () -> System.out.println("hello World!");
        r2.run();

    }

    /**
     * Lambda语法格式2：一个参数 无返回值
     */
    @Test
    public void test02() {

        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("Hello Lambda!!!");

        // 一个参数时 左边括号可以省略
        Consumer<String> con2 = x -> System.out.println(x);
        con2.accept("Hello Lambda!!!");
    }

    @Test
    public void test03() {
        Comparator<Integer> com = (x, y) -> {
            return Integer.compare(x, y);
        };

        System.out.println(com.compare(100, 23));
    }
}
