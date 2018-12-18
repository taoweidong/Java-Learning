package com.singleton;

/**
 * @author Taowd
 * @date 2018/5/21 - 23:10
 * @Description 饿汉式单例：饿汉式单例在单例类被加载时候，就实例化一个对象交给自己的引用；
 */
public class Singleton {
    /**
     * 私有化构造函数
     */
    private Singleton() {
    }
    /**
     * 类加载时即创建对象
     */
    private static Singleton singleton = new Singleton();
    /**
     * 提供给外部使用
     *
     * @return
     */
    public static Singleton getInstance() {
        return singleton;
    }
}
