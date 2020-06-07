package com.huawei.oo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * # 【加密字符串】 --已完成，但是有可能超时
 * > 有一串未加密的字符串str，通过对字符串的每一个字母改变实现加密，加密方式为在每个字母str[i]偏移特定数组元素a[i]的量，
 * 数组a前三位已经赋值，a0=1，a1=2,a2=4，当i>=3时，数组元素a[i]=ai-1  + ai-2  +ai-3 ，
 * 例如原文abcde加密后为bdgkr，其中偏移量分别是1,2,4,7,13。
 * <p>
 * - 输入：第一行为一个整数，大于等于1小于等于1000，表示有n组测试数据，每组数据包含一行原文字符串，只包含小写字母，长度大于0小于等于50，
 * - 输出：每组测试数据输出一行，表示加密后的字符串，
 * <p>
 * 解答要求：时间200ms，内存64MB，
 * <p>
 * - 举例：
 * 1
 * xy
 * 输出：
 * ya
 */
public class Huawei_20200605_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //处理输入
            int m = Integer.valueOf(sc.nextLine().trim());
            List<String> list = new ArrayList<>(m);
            for (int i = 0; i < m; i++) {
                list.add(sc.nextLine().trim());
            }

            List<String> result = new ArrayList<>();
            list.forEach(x -> {
                //计算偏移量
                int[] keyChars = new int[x.length()];
                for (int i = 0; i < x.length(); i++) {
                    keyChars[i] = getEnyKey(i);
                }
                //进行加密处理
                StringBuilder temp = new StringBuilder(x.length());
                for (int i = 0; i < x.toCharArray().length; i++) {
                    int tempChar = (int) x.charAt(i) + keyChars[i] % 26;
                    if (tempChar > 122) {
                        tempChar -= 26;
                    }
                    temp.append((char) tempChar);
                }

                //收集当前字符串的加密结果
                result.add(temp.toString());
            });

            result.forEach(x -> {
                System.out.println(x);
            });

        }
    }

    /**
     * 递归获取当前节点的偏移量
     *
     * @param i 节点号
     * @return 偏移量
     */
    private static int getEnyKey(int i) {
        //a0=1，a1=2,a2=4，当i>=3时，数组元素a[i]=ai-1  + ai-2  +ai-3 ，
        if (i == 0) {
            return 1;
        } else if (i == 1) {
            return 2;
        } else if (i == 2) {
            return 4;
        }
        return getEnyKey(i - 1) + getEnyKey(i - 2) + getEnyKey(i - 3);
    }


}


