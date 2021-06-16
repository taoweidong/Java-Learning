package com.java8;

/** 练习Java String数据方法 */
public class StringDemo {
  public static void main(String[] args) {
    // String 操作熟悉
    String str = "Hello World";

    System.out.println(str.replaceAll("o", "#"));
    System.out.println(str.replace("o", "#"));
    // 替换掉第一个匹配到的元素
    System.out.println(str.replaceFirst("o", "#"));

    System.out.println("*****************************************");
    // 码点
    int[] code = str.codePoints().toArray();
    for (int i : code) {
      System.out.println(i);
    }
    System.out.println("*****************************************");
    // 把码点数组转成字符串
    String newStr = new String(code, 0, code.length);
    System.out.println(newStr);
  }
}
