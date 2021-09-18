package com.singleton;

/**
 * @author Taowd
 * @date 2018/5/21 - 23:19
 * @Description 双重锁的形式:这个模式将同步内容下方到if内部，提高了执行的效率，不必每次获取对象时都进行同步，只有第一次才同步，创建了以后就没必要了。
 */
public class Singleton3 {

    /**
     * 设置为内存可见性
     */
    private static volatile Singleton3 instance = null;

    /**
     * 私有化构造函数
     */
    private Singleton3() {

    }

    /**
     * 提供外部调用
     * 
     * @return 实例对象
     */
    public static Singleton3 getInstance() {

        if (instance == null) {
            // 同步代码块
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
