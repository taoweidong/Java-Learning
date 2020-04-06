package com.basic.grammar;

/**
 * 抽象类示例.
 * 1.抽象类中的方法不必全部都是抽象的
 * 2.含有抽象方法的类一定是抽象类
 *
 * @author taowd
 * @date 2019年7月21日
 */
public abstract class BaseAbstractDemo {
    /**
     * 变量.
     */
    String successFlag = "success";

    /**
     * 抽象方法示例.
     * 1.含有abstract方法的类必须定义为abstract class
     *
     * @return 返回值
     */
    abstract String sayHello1();

    /**
     * 抽象类中可以定义静态方法
     * 1.抽象类中的方法不必是抽象的
     *
     * @return
     */
    public static String sayHello() {
        return "Hello World!";
    }

    /**
     * 抽象类中可以定义静态方法
     * 1.抽象类中的方法不必是抽象的
     *
     * @return
     */
    public String sayHello2() {
        return "Hello World!";
    }
}
