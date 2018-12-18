package com.nowcoder;

/**
 * @ClassName SellTickedDemo2
 * @Description 模拟电影院售票实现方式2
 * @Author Taowd
 * @Date 2018/6/9 16:31
 * @Version V1.0
 */
public class SellTickedDemo2 {

    public static class SellTick implements Runnable {
        /**
         * 票据总数
         */
        private static volatile int tickets = 100;

        private Object object = new Object();

        @Override
        public void run() {
            while (true) {
                //同步代码块解决线程安全问题
                synchronized (object) {
                    if (tickets > 0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "正在出售第【" + (tickets--) + "】张票");
                    } else {
                        Thread.interrupted();//如果票卖完了，就把线程停止掉
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SellTick sellTick = new SellTick();

        //创建三个线程对象
        Thread st1 = new Thread(sellTick, "窗口1");
        Thread st2 = new Thread(sellTick, "窗口2");
        Thread st3 = new Thread(sellTick, "窗口3");

        //启动多线程
        st1.start();
        st2.start();
        st3.start();
    }
}
