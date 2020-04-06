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
 * 题目：有两个数组a，b，大小都为n，数组元素的值任意，无序；
 * 要求： 通过交换a，b中的元素，使数组a元素的和与数组b元素的和之间的差最小。
 * https://blog.csdn.net/wentaox/article/details/72792726?depth_1-utm_source=distribute.pc_relevant.none-task-blog-OPENSEARCH-1&utm_source=distribute.pc_relevant.none-task-blog-OPENSEARCH-1
 *
 * @author Taoweidong
 */
public class HuaWei_Test20200405_01 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{14, 2, 15, 54, 23, 5};
        int[] arr2 = new int[]{7, 5, 96, 4, 35, 86};


        int[] newArr1 = new int[arr1.length];
        int[] newArr2 = new int[arr2.length];
        List dataList = sort(arr1, arr2);
        Map<String, Integer> arrMap = (Map<String, Integer>) dataList.get(0);
        String[] sortKey = (String[]) dataList.get(1);
        for (int i = 0; i < sortKey.length / 2; i++) {
            newArr1[i] = arrMap.get(sortKey[2 * i]);
            newArr2[i] = arrMap.get(sortKey[2 * i + 1]);
        }
        print(newArr1);
        print(newArr2);

    }

    public static List sort(int[] arr1, int[] arr2) {
        //新建一个Map，此处的目的是，保留每一个数字来自于哪一个数组
        Map<String, Integer> arrMap = new HashMap<String, Integer>();
        String[] keyArr = new String[arr1.length + arr2.length];
        List dataList = new ArrayList();
        for (int i = 0; i < arr1.length; i++) {
            arrMap.put("arr1[" + i + "]", arr1[i]);
            arrMap.put("arr2[" + i + "]", arr2[i]);
        }

        //对合并后的数组进行排序

        Set<String> arrSet = arrMap.keySet();
        Iterator<String> it = arrSet.iterator();
        int index = 0;
        while (it.hasNext()) {
            keyArr[index] = it.next();
            index++;
        }

        //选择排序,根据key对应的数据的大小来排列key，这样key对应的数就是有序的
        for (int i = 0; i < keyArr.length; i++) {
            for (int j = i; j < keyArr.length; j++) {
                if (arrMap.get(keyArr[i]) < arrMap.get(keyArr[j])) {
                    String temp = keyArr[i];
                    keyArr[i] = keyArr[j];
                    keyArr[j] = temp;
                }
            }
        }
        dataList.add(arrMap);
        dataList.add(keyArr);
        return dataList;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("--------------------");
    }


}