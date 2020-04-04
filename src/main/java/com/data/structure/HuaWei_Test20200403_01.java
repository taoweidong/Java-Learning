package com.data.structure;

import java.util.Scanner;

/**
 * 空白字符串替换
 *
 * @author Taoweidong
 */
public class HuaWei_Test20200403_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //处理入参中的空格和换行符
            String str1 = sc.nextLine().replaceAll(" ", "").replaceAll("\t", "");
            String str2 = sc.nextLine();

            int count = 0;
            //进行统计：使用滑动窗口的方式
            for (int i = 0; i < str1.length() - str2.length() + 1; i++) {
                if (str2.equals(str1.substring(i, i + str2.length()))) {
                    //如果当前位置开始往后滑动str2长度的字符串与str2相同时，统计值＋1
                    count++;
                }
            }

            //输出结果
            System.out.println(count);

        }
    }


}
