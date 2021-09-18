package com.basic.grammar;

/**
 * 基础训练
 *
 * @author Taoweidong
 */
public class HuaWei_Test_20200406_01 extends Test001 {
    @Override
    int test001() {
        return 0;
    }

    public static void main(String[] args) {
        Test001 test002 = new HuaWei_Test_20200406_01();
    }
}

abstract class Test001 {

    private int test() {
        return 0;
    }

    public int test002() {
        return 0;
    }

    public static void sayHello() {
        System.out.println("Hello World!!");
    }

    /**
     * 抽象方法:抽象方法必须被子类实现
     *
     * @return
     */
    abstract int test001();
}
