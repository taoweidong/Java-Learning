package com.juc;

/**
 * 题目：判断输出结果，分析多线程锁的概念</br>
 * 1. 两个普通同步方法，两个线程，标准打印， 打印? //one two 2. 新增 Thread.sleep() 给 getOne() ,打印? //one two 3. 新增普通方法 getThree() , 打印?
 * //three one two 4. 两个普通同步方法，两个 Number 对象，打印? //two one 5. 修改 getOne() 为静态同步方法，打印? //two one 6. 修改两个方法均为静态同步方法，一个
 * Number 对象? //one two 7. 一个静态同步方法，一个非静态同步方法，两个 Number 对象? //two one 8. 两个静态同步方法，两个 Number 对象? //one two
 */
public class TestThread8Monitor {

    // 所有的非静态同步方法用的都是同一把锁——实例对象本身，也就是说如果一个实
    // 例对象的非静态同步方法获取锁后，该实例对象的其他非静态同步方法必须等待获
    // 取锁的方法释放锁后才能获取锁，可是别的实例对象的非静态同步方法因为跟该实
    // 例对象的非静态同步方法用的是不同的锁，所以毋须等待该实例对象已获取锁的非
    // 静态同步方法释放锁就可以获取他们自己的锁。
    //
    //
    // 所有的静态同步方法用的也是同一把锁——类对象本身，这两把锁是两个不同的对
    // 象，所以静态同步方法与非静态同步方法之间是不会有竞态条件的。但是一旦一个
    // 静态同步方法获取锁后，其他的静态同步方法都必须等待该方法释放锁后才能获取
    // 锁，而不管是同一个实例对象的静态同步方法之间，还是不同的实例对象的静态同
    // 步方法之间，只要它们同一个类的实例对象！

    public static void main(String[] args) {

        Number number = new Number();
        Number number2 = new Number();

        new Thread(new Runnable() {

            @Override
            public void run() {

                number.getOne();
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {

                number2.getTwo();
            }
        }).start();

    }
}

class Number {

    public static synchronized void getOne() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("one");
    }

    public static synchronized void getTwo() {

        System.out.println("two");
    }

}
