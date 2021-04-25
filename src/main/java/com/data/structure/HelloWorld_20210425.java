package com.data.structure;

import java.util.Arrays;

/***
 * 数组的使用方法复习
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
    System.out.println(Arrays.toString(aArray));
    System.out.println(Arrays.toString(bArray));
    System.out.println(Arrays.toString(cArray));
    System.out.println(cArray);
  }
}
