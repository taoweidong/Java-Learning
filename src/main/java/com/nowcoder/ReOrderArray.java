package com.nowcoder;

import java.util.Arrays;
import java.util.Vector;

/**
 * @ClassName ReOrderArray
 * @Description 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @Author Taowd
 * @Date 2018/5/28 13:36
 * @Version V1.0
 */
public class ReOrderArray {
    public static void main(String[] args) {
        int[] a = new int[]{12, 33, 3, 67, 87, 88, 60, 45};
        System.out.println(Arrays.toString(a));
        reOrderArray(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * @param array
     */
    public static void reOrderArray(int[] array) {
        //创建集合存储奇数和偶数
        Vector<Integer> vector = new Vector<Integer>();
        Vector<Integer> vector2 = new Vector<Integer>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                vector.add(array[i]);
            } else {
                vector2.add(array[i]);
            }
        }
        vector2.addAll(vector);//合并两个集合
        //更新数组，最终结果
        for (int i = 0; i < vector2.size(); i++) {
            array[i] = vector2.get(i);
        }
    }
}
