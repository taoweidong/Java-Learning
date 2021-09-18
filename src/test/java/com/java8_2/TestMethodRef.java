package com.java8_2;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.junit.Test;

import com.java8.Employee;

/**
 * 方法引用:若Lambda体中的内容有方法已经实现了，我们可以使用“方法引用”(可以理解为方法引用是Lambda表达式的另一种表现形式)<br/>
 * 注意:Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型中保持一致<br/>
 * 对象::实例方法名<br/>
 * 类::静态方法名<br/>
 * 类::实例方法名<br/>
 * 
 * @author Taowd
 * @date 2018年12月24日
 */
public class TestMethodRef {

    @Test
    public void test04() {
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        System.out.println(bp.test("asd", "asd00"));

        BiPredicate<String, String> bp2 = String::equals;
        System.out.println(bp2.test("hello", "world"));

    }

    @Test
    public void test03() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        System.out.println(com.compare(12, 36));

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(233, 100));
    }

    @Test
    public void test01() {
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("Hello");

        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;
        con1.accept("Hello World!");

        Consumer<String> con2 = System.out::println;
        con2.accept("你好 世界！");
    }

    @Test
    public void test02() {
        Employee emp = new Employee(1002, "Tom", 23, 36.25);
        Supplier<String> sup = () -> emp.getName();
        System.out.println(sup.get());

        Supplier<Integer> sup2 = emp::getAge;
        System.out.println(sup2.get());
    }
}
