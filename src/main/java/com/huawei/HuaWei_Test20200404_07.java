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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Scanner;

/**
 * @author Taoweidong
 */
public class HuaWei_Test20200404_07 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        //输入样例：2018 02 3 1
        String[] str = in.nextLine().split(" ");
        //年
        int year = Integer.valueOf(str[0]);
        //月
        int month = Integer.valueOf(str[1]);
        //周
        int week = Integer.valueOf(str[2]);
        //周几
        int day = Integer.valueOf(str[3]);

        String result = "0";
        try {
            LocalDate date = LocalDate.of(year, month, 1);
            //检查周和周几的合法性
            if (week <= 0 || week > 4) {
                result = "0";
            }
            if (day <= 0 || day > 7) {
                result = "0";
            }

            //将date月的日期一个一个遍历，检查周和天是否在本月
            while (month == date.getMonthValue()) {
                //当前日期为本月的第几周
                int currentWeek = date.getDayOfWeek().getValue();
                //可以获取当前日期为周几
                int currentWeekDay = date.getDayOfWeek().getValue();
                //检查周是否在本月
                if (currentWeek == week) {
                    //如果当前周没有指定的周
                    if (currentWeek > day) {
                        result = date.with(ChronoField.DAY_OF_WEEK, 1).toString();
                        break;
                    }

                    //检查当天是否在本月
                    if (currentWeekDay == day) {
                        result = date.format(DateTimeFormatter.ofPattern("yyyy-mm-dd"));
                        break;
                    }
                }
                date = date.plusDays(1);

            }

        } catch (Exception e) {
            result = "0";
        }

        System.out.println(result);
    }


}