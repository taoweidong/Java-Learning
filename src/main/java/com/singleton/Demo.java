package com.singleton;

public class Demo {

    /**
     * 内部对象
     */
    private static volatile Demo instance;

    /**
     * 私有化构造参数
     */
    private Demo() {}

    public static synchronized Demo getInstance() {

        if (instance == null) {
            // 同步代码块
            synchronized (Demo.class) {
                if (instance == null) {
                    instance = new Demo();
                }
            }
        }

        return instance;
    }
}
