package com.huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 最大客人数量:
 * 举办一场8小时的聚会，时间段从12：00到20：00点，让来访的客人事先填写好到达的时间和离开的时间，为了掌握聚会期间座位的数目，
 * 需要先估计不同时间的最大客人数量。
 * <p>
 * 到达和离开的时间，以整点计算，输入为整数，比如“12，18”表示该客人到达时间为12点后13点前，离开时间是17点后18点前
 * 按小时区间统计客人的数量，需要统计[12,13)，[13,14)…[19,20)共8个时间段的最大客人数量
 * 假设邀请的客人最多100个
 * 题目给了一个样例：
 * 假设输入为
 * [12,15),[16,17),[12,20),
 * 输出为[12,13)：2，[13,14)：2，[14,15)：2，[15,16)：1，[16,17)：1，[17,18)：1，[18,19)：1，[19,20)：1
 *
 * @author Taoweidong
 */
public class HuaWei_Test20200404_01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            //思路：统计每一个时间段的最大人数
            //1、把每一个输入读进来，拆成不同的时间段存储到Map中进行计数
            //2、对Map中的结果进行排序
            //3、输出结果

            //存储结果:TreeMap包含自然排序
            Map<String, Integer> result = new TreeMap<>();
            //处理输入:输入格式[12,15),[16,17),[12,20),
            String[] inputArr = sc.nextLine().split("\\),");
            for (int i = 0; i < inputArr.length; i++) {
                //处理完毕后的数据为：[12,13]
                String[] temp = inputArr[i].substring(1).split(",");
                if (temp.length == 2) {
                    int start = Integer.valueOf(temp[0]);
                    int end = Integer.valueOf(temp[1]);
                    for (int j = start; j < end; j++) {
                        String key = "[" + j + "," + (j + 1) + ")";
                        result.put(key, result.getOrDefault(key, 0) + 1);
                    }
                }
            }

            //输出结果
            StringBuilder outputStr = new StringBuilder();
            result.entrySet().stream().forEach(x -> {
                outputStr.append(x.getKey() + ":" + x.getValue() + ",");
            });
            System.out.println(outputStr.toString().substring(0, outputStr.length() - 1));


        }
    }


}
