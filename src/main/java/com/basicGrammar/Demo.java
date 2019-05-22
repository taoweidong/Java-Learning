package com.basicGrammar;


/**
 * Float进行运算时出现错误的情况分析<br/>
 * 浮点数在内存中是按照IEEE754标准进行存储的。 计算机内部是通过二进制也就是0和1来存储数据的，浮点数也不例外，但是有些浮点数是无法精确存储的，只有由2的幂组成的数才可以精确存储。
 * 2.0f在内存中可以准确的存储：<br/>
 * 解决方法：通过java.math包中提供的BigDecimal类可以解决此类问题 參考：https://blog.csdn.net/cflys/article/details/70768110
 * 
 * @author taowd
 * @version 2019年5月7日
 * @see Demo
 */
public class Demo {

  public static void main(String[] args) {

    for (float i = 1; i < 10 + 0.1f; i = i + 0.1f) {
      System.out.println(i);
    }
    // float ff = 1f;
    // ff = ff + 0.1f;
    // System.out.println(ff);
    // ff = ff + 0.1f;
    // System.out.println(ff);
    // ff = ff + 0.1f;
    // System.out.println(ff);
    // ff = ff + 0.1f;
    // System.out.println(ff);
    // ff = ff + 0.1f;
    // System.out.println(ff);
    // ff = ff + 0.1f;
    // System.out.println(ff);



  }
}
