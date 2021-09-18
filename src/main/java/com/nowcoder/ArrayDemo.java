package com.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Taowd
 * @Description 有数组a[n]，用java代码将数组元素顺序颠倒
 */
public class ArrayDemo {

    public static void main(String[] args) {

        int[] a = new int[] {(int)(Math.random() * 1000), (int)(Math.random() * 1000), (int)(Math.random() * 1000),
            (int)(Math.random() * 1000)};
        System.out.println(Arrays.toString(a));
        swapNew(a);
        System.out.println(Arrays.toString(a));

    }

    public static void swap(int a[]) {

        int len = a.length;
        for (int i = 0; i < len / 2; i++) {
            int temp = a[i];
            // 最后一个元素赋值给第一个元素
            a[i] = a[len - 1 - i];
            a[len - 1 - i] = temp;
        }
    }

    /**
     * 数组反转 思路：使用集合的reverse反转方法
     * 
     * @param a
     */
    public static void swapNew(int a[]) {

        ArrayList<Integer> array_list = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            array_list.add(a[i]);
        }
        Collections.reverse(array_list);
        Integer[] data = array_list.toArray(new Integer[array_list.size()]);
        for (int i = 0; i < data.length; i++) {
            a[i] = data[i];
        }
    }

}
