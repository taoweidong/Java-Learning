package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * A四大核心函数式接口 Consumer<T> :消费型接口 void accept(T t) Supplie<T> :供给型接口
 * 
 * @author Taowd
 * @date 2018年12月20日
 */
public class TestLambda3 {

	/**
	 * 测试Consumer<T t>消费型接口
	 */
	@Test
	public void consumerTest() {

		happy(10000, (m) -> System.out.println("消费开始--->" + m));

	}

	public void happy(double money, Consumer<Double> con) {
		con.accept(money);
	}

	// Supplier<T> 供给型接口
	@Test
	public void test2() {

		List<Integer> num = getNumberList(10, () -> (int) (Math.random() * 100));
		num.forEach(System.out::println);

	}

	public List<Integer> getNumberList(int num, Supplier<Integer> sup) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < num; i++) {
			Integer n = sup.get();
			list.add(n);
		}
		return list;
	}

	// 函数型接口：Function<T,R>
	@Test
	public void test03() {
		String result = strHandler("helllo world        ", (str) -> str.trim().toUpperCase());
		System.out.println(result);

		String length = strHandler("helllo world        ", (str) -> str.trim().length() + "");
		System.out.println(length);

	}

	public String strHandler(String str, Function<String, String> fun) {
		return fun.apply(str);
	}

	// 断言型接口 Predicate<T>
	List<Employee> emps = Arrays.asList(//
			new Employee(101, "张三", 15, 2225.22), //
			new Employee(102, "王五", 34, 6666.22), //
			new Employee(103, "马六", 45, 8888.22), //
			new Employee(104, "诸葛小坏", 78, 3455.22), //
			new Employee(105, "李四", 24, 8966.89));

	@Test
	public void test04() {
		List<String> list = new ArrayList<String>();
		list.add("张三");
		list.add("李四");
		list.add("王武");
		list.add("tom");
		list.add("joney");

		List<String> resultList = filterStr(list, x -> x.length() == 2);
		resultList.forEach(System.out::println);

		System.out.println("--------------");

		List<Employee> empList = filterEmp(emps, x -> x.getAge() > 40);

		empList.forEach(System.out::println);

	}

	public List<Employee> filterEmp(List<Employee> list, Predicate<Employee> pre) {
		List<Employee> resultList = new ArrayList<Employee>();
		for (Employee item : list) {
			if (pre.test(item)) {
				resultList.add(item);
			}
		}
		return resultList;
	}

	public List<String> filterStr(List<String> list, Predicate<String> pre) {
		List<String> resultList = new ArrayList<String>();
		for (String item : list) {
			if (pre.test(item)) {
				resultList.add(item);
			}
		}
		return resultList;
	}

}
