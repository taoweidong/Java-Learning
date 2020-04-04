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

import java.util.*;

/**
 * 【题目描述】：
 * 有m个并行处理器，n个任务（n>m），按照短作业优先进行调度，计算处理完所有任务的耗时。
 * <p>
 * 【输入描述】：
 * m n  两个正整数，m是处理器的个数，n是任务数;用空格分隔
 * t1 t2 ... tn 每个任务的处理时长；用空格分隔
 * <p>
 * 【输出描述】：
 * 输出总处理时长
 * <p>
 * 【测试用例】：
 * 【输入】：
 * 3 5
 * 5 4 3 1 10
 * 【输出】：
 * 13
 * ————————————————
 * 版权声明：本文为CSDN博主「kabuto_hui」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/kabuto_hui/java/article/details/90724006
 *
 * @author Taoweidong
 */
public class HuaWei_Test20200404_03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] inputStr = in.nextLine().split(" ");
            //CPU的个数
            int cpuCount = Integer.valueOf(inputStr[0]);
            //任务的个数
            int taskCount = Integer.valueOf(inputStr[1]);

            List<Integer> cpuList = new ArrayList<>(cpuCount);
            //任务数:按照从小往大排序
            PriorityQueue<Integer> taskList = new PriorityQueue<>(taskCount);
            String[] task = in.nextLine().split(" ");
            for (int i = 0; i < task.length; i++) {
                taskList.add(Integer.valueOf(task[i]));
            }

            //先把初始任务添加到cpu中
            for (int i = 0; i < cpuCount; i++) {
                //任务分配后，任务会从taskList删除掉
                cpuList.add(taskList.poll());
            }

            //记录最终的结果，任务执行完毕的最小耗时
            int result = 0;
            //每次减去的最小任务
            int min = Collections.min(cpuList);


            //开始进行任务执行
            while (true) {
                //cpu当前的最小任务
                int currentMin = Integer.MAX_VALUE;
                for (int i = 0; i < cpuList.size(); i++) {
                    if (cpuList.get(i) != 0) {
                        //任务执行,减去当前cpu中的最小任务时间
                        cpuList.set(i, cpuList.get(i) - min);
                        //检查cpu中的任务是否已经执行完毕，如果已经执行完毕，则添加新的任务进来
                        if (cpuList.get(i) == 0) {
                            if (!taskList.isEmpty()) {
                                //取最小的任务
                                cpuList.set(i, taskList.poll());
                            }
                        }


                    }
                    //求当前任务的最小值
                    if (cpuList.get(i) != 0 && cpuList.get(i) < currentMin) {
                        currentMin = cpuList.get(i);
                    }
                }
                result += min;

                if (currentMin == Integer.MAX_VALUE) {
                    //CPU处理完毕
                    break;
                }
                min = currentMin;
            }

            //输出结果
            System.out.println(result);
        }

    }


}