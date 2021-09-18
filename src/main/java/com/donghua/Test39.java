package com.donghua;

public class Test39 {

    public static void main(String[] args) throws Exception {

        AbstractHello hello = new HelloImpl();
        hello.method1();

    }

}

abstract class AbstractHello {

    public void method1() {

        System.out.println("我是AbstractHello类中的method1方法，调用了method2方法，method2的输出结果：" + method2());

    }

    /**
     * 这是一个抽象方法，供method1调用
     */
    abstract String method2();
}

class HelloImpl extends AbstractHello {

    @Override
    String method2() {

        return "我是HelloImpl子类实现的method2方法";
    }
}
