package com.singleton;

/**
 * @author Taowd
 * @date 2018/5/21 - 23:14
 * @Description  懒汉式单例：懒汉式在调用取得实例方法的时候才会实例化对象。
 */
public class Singleton2 {
    /**
     * 私有化构造函数
     */
    private Singleton2() {
    }

    /**
     * 内部变量
     */
    private static Singleton2 singleton2;

    /**
     * 对外方法
     *
     * @return
     */
    public static synchronized Singleton2 getInstance() {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
