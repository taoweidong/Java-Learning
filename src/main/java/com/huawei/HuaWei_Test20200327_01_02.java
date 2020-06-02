package com.huawei;

import java.util.*;

/**
 * 查找算式最小值：
 * 对于给定的10个整数，从中任意选出3个，代入算式X+XY-Y+Z,要求求出算式最小值
 * 例如：
 * 1 1 3 1 1 1 1 1 1 1
 * 结果：2
 * https://blog.csdn.net/weixin_39971186/article/details/103315477
 * <p>
 * 考察点，字符串的递归排序
 *
 * @author Taoweidong
 */
public class HuaWei_Test20200327_01_02 {

    private static ArrayList<Integer> resultList = new ArrayList<>();
    //所有的组合方式以|分割
    private static StringBuffer extractPermutationResult = new StringBuffer();

    public static void main(String[] args) {
        // int[] arr = {1, 23, 2, 5, 6, 9, 8, 10, 25, 36};
        int[] arr = {1, 1, 3, 1, 1, 1, 1, 1, 1, 1};
        getPermutation(0, 3, arr);
        //System.out.println(extractPermutationResult);

        System.out.println(getResult());


    }

    private static StringBuffer fullPermutationResult = new StringBuffer();

    /**
     * 给定一个字符串数组，求字符串数组中所有字符串的全排列组合结果
     * DFS+回溯(多路递归)：https://blog.csdn.net/Xenoverse/article/details/88559434
     *
     * @param arr   需要排列组合的字符串数组
     * @param point 数组指针
     */
    public static void fullPermutation(String arr[], int point) {
        //跳出递归的条件
        if (point == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                //System.out.print(arr[i] + " ");
                fullPermutationResult.append(arr[i] + " ");
            }
            fullPermutationResult.append("|");
            //System.out.println();
        }

        //多路递归
        for (int i = point; i < arr.length; i++) {
            //交换当前分支里面的元素，使他成为当前分支所有元素中的第一个元素
            String temp1 = arr[point];
            arr[point] = arr[i];
            arr[i] = temp1;

            //进入更下一层分支
            fullPermutation(arr, point + 1);

            //下一层分支已经结束，我们需要把交换了的元素交换调整原样
            String temp2 = arr[point];
            arr[point] = arr[i];
            arr[i] = temp2;
        }
    }

    /**
     * 指定的数组中随机抽取三个数，然后带入公式:X+XY-Y+Z中，
     * 求出这十个数中随意随机出来的三个数带入这个公式的最小值
     *
     * @return 最小值
     */
    public static int getResult() {
        //存放每计算出来的三个随机数结果的集合
        ArrayList<Integer> resultList = new ArrayList<>();
        //从数组长度为10的数组中随机取出3个数，排列组合最终拿到的组合结果数组
        String[] combinationResult = extractPermutationResult.toString().split("\\|", -1);
        for (String c : combinationResult) {
            String[] strArr = c.split(",");
            //对每个随机抽取出来的三位数进行全排列组合
            fullPermutation(strArr, 0);
            //对每个随机抽取出来的三位数进行全排列组合之后的结果数组
            String[] fullPermutationResultArr = fullPermutationResult
                    //去掉fullPermutationResult字符串拼接的最后一个"|"
                    .delete(fullPermutationResult.length() - 1, fullPermutationResult.length())
                    .toString().split("\\|", -1);
            for (String s : fullPermutationResultArr) {
                String[] strNum = s.split(" ");
                int x = Integer.parseInt(strNum[0]);
                int y = Integer.parseInt(strNum[1]);
                int z = Integer.parseInt(strNum[2]);
                //带入指定的公式对每个三位数组合进行结果值计算：X+XY-Y+Z
//                int result = (int) (Math.pow(x, 2) + x * y - Math.pow(y, 2) + z);
                int result = (int) (x + x * y - y + z);
                //将每次计算的结果放入结果集合中进行保存
                resultList.add(result);
            }
        }
        //最终对结果集合进行升序排序
        Collections.sort(resultList);
        //返回所有排列组合计算出的最小结果值
        return resultList.get(0);
    }

    /**
     * 在给定数组arr中获取count个数的所有排列组合
     *
     * @param index 首个索引下标
     * @param count 每次取几个数
     * @param arr   给定数组
     * @return
     */
    public static void getPermutation(int index, int count, int[] arr) {
        if (count > arr.length || arr.length <= 0) {
            return;
        }

        if (count == 1) {
            for (int i = index; i < arr.length; i++) {
                resultList.add(arr[i]);
                for (Integer item : resultList) {
                    extractPermutationResult.append(item).append(",");
                }
                extractPermutationResult.delete(extractPermutationResult.length() - 1, extractPermutationResult.length()).append("|");
//                System.out.println(resultList);
                resultList.remove((Object) arr[i]);
            }
        } else if (count > 1) {
            for (int i = index; i < arr.length - count; i++) {
                resultList.add(arr[i]);
                //递归的方式在数组arr中找count-1个数的组合
                getPermutation(i + 1, count - 1, arr);
                resultList.remove((Object) arr[i]);
            }
        } else {
            return;
        }
    }
}
