package com.huawei;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 给定两个字符集合，一个为全量字符集，一个为已占用字符集。已占用的字符集中的字符不能再使用，要求输出剩余可用字符集。
 * 输入描述：输入为一个字符串，字符串中包含了全量字符集和已占用字符集，两个字符集使用@连接，前面为全量，后面为已占用。
 * 已占用字符集中的字符一定是全量字符集中的字符。
 * 字符集中的字符跟字符之间用英文逗号分隔。
 * 字符集中的字符表示为字符加数字，字符跟数字使用英文冒号分隔，比如a:1,表示1个a字符。字符只考虑英文字母，区分大小写，数字只考虑正整形，数量不超过100，如果一个字符都没被占用，@标识仍然存在，例如a:3,b:5,c:2@
 * 示例1：
 * 输入
 * a:3,b:5,c:2@a:1,b:2
 * 输出
 * a:2,b:3,c:2
 * 注意：输出的字符顺序要跟输入一致！如果某个字符已全被占用，不需要再输出！
 * 示例2：
 * 输入
 * a:3,b:5,c:2@a:3,b:2
 * 输出
 * b:3,c:2
 * ————————————————
 * 版权声明：本文为CSDN博主「潇霖呀爱吃鱼」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/JH_Shawlin/java/article/details/100898028
 *
 * @author Taoweidong
 */
public class HuaWei_Test20200403_03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Map<String, Integer> map = new LinkedHashMap<>();
            //处理输入：a:3,b:5,c:2@a:1,b:2
            String[] inputStr = sc.nextLine().split("@");

            //处理全量字符串集
            for (String item : inputStr[0].split(",")) {
                String[] tempArr = item.split(":");
                map.put(tempArr[0], Integer.valueOf(tempArr[1]));
            }

            if (inputStr.length == 2) {
                //进行逻辑处理
                for (String item : inputStr[1].split(",")) {
                    String[] tempArr = item.split(":");
                    map.put(tempArr[0], map.get(tempArr[0]) - Integer.valueOf(tempArr[1]));
                }
            }


            //输出结果
            StringBuilder output = new StringBuilder();
            map.entrySet().forEach(x -> {
                if (x.getValue() > 0) {
                    output.append(x.getKey() + ":" + x.getValue() + ",");
                }
            });
            System.out.println(output.toString().substring(0, output.length() - 1));

        }
    }


}
