package com.java8_4;

import java.util.Optional;

import org.junit.Test;

import com.java8.Employee;

/**
 * Optional 容器类的常用方法
 * @author Taowd
 * @version 2018年12月27日
 * @see OptionalTest
 */
public class OptionalTest {

	@Test
	public void test01() {
		Optional<Employee> op = Optional.of(new Employee());

		if (op.isPresent()) {
			System.out.println("有值");
		}

		System.out.println(op.get());

	}

}
