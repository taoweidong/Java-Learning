package com.data.structure;

/***
 * 数组的使用方法复习
 *
 * @author Taoweidong
 */
public class HelloWorld_20210425 {
    public static void main(String[] args) {
        // https://www.cnblogs.com/chenpi/p/5507806.html
        // http://c.biancheng.net/java/70/
        // 数组的定义(声明)
        String[] aArray = new String[10];
        Integer[] bArray = {1, 2, 3, 4};
        String[] cArray = new String[] {"a", "b", "c"};

        // 方法练习
        // System.out.println(Arrays.toString(aArray));
        // System.out.println(Arrays.toString(bArray));
        // System.out.println(Arrays.toString(cArray));
        // System.out.println(cArray);

        System.out.println("********************************");
        int[][] arr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {1, 3, 5, 7, 9}, {2, 4, 6, 8, 10}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("********************************");
        // 取上下左右四个元素
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        // 取上下左右对角线，八个元素
        // int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

        // 以下这种方式可以快速获取到二维数组中指定位置上下左右，元素的列表
        int i = 1;
        int j = 1;
        for (int[] ints : direction) {
            int newX = i + ints[0];
            int newY = j + ints[1];
            if (newX >= 0 && newX < arr.length && newY >= 0 && newY < arr[0].length) {
                System.out.print(arr[newX][newY] + "\t");
            }

        }

    }
}
