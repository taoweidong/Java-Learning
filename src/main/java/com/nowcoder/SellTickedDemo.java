package com.nowcoder;

/**
 * @ClassName SellTickedDemo
 * @Description 模拟电影院售票 问题：相同的票买了多次：CUP的操作必须是原子性的 出现负票的原因：随机性和延迟导致的
 * @Author Taowd
 * @Date 2018/6/9 16:05
 * @Version V1.0
 */
public class SellTickedDemo {

    /**
     * 买票的
     */
    public static class SellTicket extends Thread {

        private Object object = new Object();
        // 定义100张票
        private static volatile int tickets = 100;

        @Override
        public void run() {
            while (true) {
                // 同步代码块解决线程安全问题
                synchronized (object) {
                    if (tickets > 0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(getName() + "正在出售第【" + (tickets--) + "】张票");
                    } else {
                        Thread.interrupted();// 如果票卖完了，就把线程停止掉
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // 创建三个线程对象
        SellTicket st1 = new SellTicket();
        SellTicket st2 = new SellTicket();
        SellTicket st3 = new SellTicket();
        // 给线程起名字
        st1.setName("窗口1");
        st2.setName("窗口2");
        st3.setName("窗口3");
        // 启动多线程
        st1.start();
        st2.start();
        st3.start();

    }

}
