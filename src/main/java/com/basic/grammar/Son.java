package com.basic.grammar;

/**
 * 1、super() 最前 2、静态常量&静态代码块(按照定义顺序执行) 3、非静态常量&非静态代码块(按照定义顺序执行) 4、构造器(最后)
 */
public class Son extends Father {

    private int i = test();

    private static int j = method();
    static {
        System.out.println("(6)");
    }

    Son() {

        System.out.println("(7)");
    }

    {
        System.out.println("(8)");
    }

    /**
     * 注意：此处有方法重写的问题 默认调用的对象是当前创建的对象
     * 
     * @return
     */
    public int test() {

        System.out.println("(9)");
        return 1;
    }

    public static int method() {

        System.out.println("(10)");
        return 1;
    }

    public static void main(String[] args) {

        Father son = new Son();
        System.out.println();
        Father s2 = new Son();

    }
}
