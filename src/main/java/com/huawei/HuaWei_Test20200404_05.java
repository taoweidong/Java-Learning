//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
//网格的四个边均被水包围。 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集

package com.huawei;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 报文转义
 * 0x07
 * 0x0D
 * 0x0A
 * 0x0B
 * 0x0D
 * 0x0A
 * 0x0B
 * 输出：B D 12 34 AB CD D 12 34 AB CD
 *
 * @author Taoweidong
 */
public class HuaWei_Test20200404_05 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            //输入信息
            String str = in.nextLine();
            //将输入的长度转为十六进制
            BigInteger num = new BigInteger(str.replace("0x", ""), 16);
            int length = num.intValue();

            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < length - 1; i++) {
                str = in.nextLine();
                if ("0x0A".equals(str)) {
                    list.add("12");
                    list.add("34");
                } else if ("0x0B".equals(str)) {
                    list.add("AB");
                    list.add("CD");
                } else {
                    list.add(str.substring(2).substring(str.indexOf("0") + 1));
                }
            }

            String outputLength = Integer.toHexString(list.size() + 1).toUpperCase();
            System.out.println(outputLength + " " + String.join(" ", list));

        }

    }


}