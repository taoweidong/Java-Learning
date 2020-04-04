package com.huawei;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 磁盘的容量单位有M、G、T，其关系为 1T = 1000G、1G = 1000M，如样例所示先输入磁盘的个数，再依次输入磁盘的容量大小，
 * 然后按照从小到大的顺序对磁盘容量进行排序并输出。
 * 磁盘容量排序:https://www.cnblogs.com/codeapes666/p/12445607.html
 * 3
 * 1T
 * 20M
 * 3G
 *
 * @author Taoweidong
 */
public class HuaWei_Test20200331_02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //输入参数
            int count = Integer.valueOf(sc.nextLine());
            //PriorityQueue :这个类的排序不是在添加元素的时候排序的，而是在使用poll()方法取值的时候进行排序，使用时一定注意
            PriorityQueue<Disk> disks = new PriorityQueue<Disk>((x, y) -> x.mv - y.mv);
            for (int i = 0; i < count; i++) {
                String str = sc.nextLine();

                Integer m = Integer.valueOf(str.substring(0, str.length() - 1));
                String v = str.substring(str.length() - 1);

                Disk disk = new Disk(m, v);
                disks.add(disk);
            }
            //注意此处此时使用PriorityQueue优先队列进行排序是，结果取值不能使用普通的迭代，必须使用.poll()方法
            // 用加强for循环会无法排序，因为直接取出来没有进行比较
            //正确取值的方式
            while (!disks.isEmpty()) {
                //调用poll方法时候会进行比较；
                Disk d = disks.poll();
                System.out.println(d.m + d.v);
            }

        }
    }

}

class Disk {

    /**
     * 容量大小
     */
    public Integer m;

    /**
     * 单位
     */
    public String v;

    /**
     * 单位换算后的大小
     */
    public int mv;

    public Disk(Integer m, String v) {

        this.m = m;
        this.v = v;
        if ("G".equals(v)) {
            this.mv = m * 1000;
        } else if ("T".equals(v)) {
            this.mv = m * 1000 * 1000;
        } else {
            this.mv = m;
        }
    }

}
