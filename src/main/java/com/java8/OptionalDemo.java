package com.java8;

import java.util.Optional;

import com.alibaba.fastjson.JSON;

/**
 * Java8新特性Optional类
 * 
 * @author taowd
 * @version 2019年5月5日
 * @see OptionalDemo
 */
public class OptionalDemo {

    public static void main(String[] args) {

        Optional<Employee> op = Optional.ofNullable(new Employee());
        System.out.println(op.isPresent());

        op = Optional.ofNullable(null);
        System.out.println(op.isPresent());

        // System.out.println(JSON.toJSONString(op.get()));
        System.out.println(JSON.toJSONString(op.orElseGet(() -> new Employee())));

        Optional<String> str = op.flatMap((x) -> Optional.of(x.getName()));
        System.out.println(str.isPresent());
    }
}
