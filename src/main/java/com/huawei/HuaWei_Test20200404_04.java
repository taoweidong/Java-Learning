// 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
// 网格的四个边均被水包围。
//
// 示例 1:
//
// 输入:
// 11110
// 11010
// 11000
// 00000
//
// 输出: 1
//
//
// 示例 2:
//
// 输入:
// 11000
// 11000
// 00100
// 00011
//
// 输出: 3
//
// Related Topics 深度优先搜索 广度优先搜索 并查集

package com.huawei;

import java.util.*;

/**
 * 【题目描述】： 输入两个ip地址和一个子网掩码，判断这两个ip地址是否属于同一网段（ip地址与子网掩码按位与，结果相同）。 要求输出是否同一个网段（0否， 1是）和第一个ip与子网掩码按位与的结果
 * <p>
 * 【输入描述】： ip1 ip2 子网掩码（按空格隔开）
 * <p>
 * 【输出描述】： 0或者1 第一个ip与子网掩码按位与的结果（用空格隔开）
 * <p>
 * 【测试用例】： 【输入】： 192.168.1.1 192.168.1.2 255.255.255.0 【输出】： 1 190.168.1.0 ———————————————— 192.168.1.1 192.168.1.2
 * 255.255.255.0 1 192.168.1.0 192.168.1.1 192.199.1.2 255.255.255.0 0 192.168.1.0 版权声明：本文为CSDN博主「kabuto_hui」的原创文章，遵循 CC
 * 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。 原文链接：https://blog.csdn.net/kabuto_hui/java/article/details/90724006
 *
 * @author Taoweidong
 */
public class HuaWei_Test20200404_04 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            // 【输入】： 192.168.1.1 192.168.1.2 255.255.255.0
            // 【输出】：1 190.168.1.0
            String[] inputStr = in.nextLine().split(" ");
            String[] ip1 = inputStr[0].split("\\.");
            String[] ip2 = inputStr[1].split("\\.");
            String[] mask = inputStr[2].split("\\.");

            // 是否同一网段标志
            int flag = 1;
            // 最终IP
            StringBuilder ouputIp = new StringBuilder();
            for (int i = 0; i < ip1.length; i++) {
                ouputIp.append((Integer.valueOf(ip1[i]) & Integer.valueOf(mask[i])) + ".");
                if ((Integer.valueOf(ip1[i]) & Integer.valueOf(mask[i])) != (Integer.valueOf(ip2[i])
                    & Integer.valueOf(mask[i]))) {
                    flag = 0;
                }
            }

            System.out.println(flag + " " + ouputIp.toString().substring(0, ouputIp.length() - 1));

        }

    }

}