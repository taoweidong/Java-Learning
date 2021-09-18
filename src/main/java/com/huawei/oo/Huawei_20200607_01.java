package com.huawei.oo;

import java.util.*;

/**
 * # 【数字排列】https://blog.csdn.net/Jocelyn92/article/details/69808047 > 题目描述：小明负责公司年会，想出一个趣味游戏：屏幕给出1~9中任意3个不重复的数字，
 * 大家以最快时间给出这几个数字可拼成的数字从小到大排列位于第N位置的数字，其中N为给出的数字中最大的（如果不到这么多个数字则给出最后一个即可），谁最快给出谁得奖。
 * <p>
 * > 注意： - 1、2可以当作5来使用，5可以当作2来使用进行数字拼接，且屏幕不能同时给出2和5； - 2、6可以当作9来使用，9可以当作6来使用进行数字拼接，且屏幕不能同时给出6和9； -
 * 如果给出1，4，8，则可以拼接成的数字为1，4，8，14，18，41，48，81，84，148，184，418，481，814，841。那么最第N（即8)个数字为81。
 * <p>
 * - 输入描述：输入以逗号分隔的描述3个int类型整数的字符串。 - 输出描述： 输出为这几个数字可以拼成的数字，从小到大排列于第N（N为输入数字中国最大的数字）位置的数字，如果输入的数字不在范围内或者有重复，则输出-1。
 * <p>
 * - 示例： 输入 1,4,8 输出 81
 */
public class Huawei_20200607_01 {
    /**
     * 计算给定三个数的全部排列组合方式
     *
     * @param lst
     *            最终结果
     * @param a
     *            数字1
     * @param b
     *            数字2
     * @param c
     *            数字3
     */
    public static void addThreeNumbers(List<Integer> lst, int a, int b, int c) {
        lst.add(a);
        lst.add(b);
        lst.add(c);
        lst.add(a * 10 + b);
        lst.add(a * 10 + c);
        lst.add(b * 10 + a);
        lst.add(b * 10 + c);
        lst.add(c * 10 + a);
        lst.add(c * 10 + b);

        lst.add(a * 100 + b * 10 + c);
        lst.add(a * 100 + c * 10 + b);
        lst.add(b * 100 + a * 10 + c);
        lst.add(b * 100 + c * 10 + a);
        lst.add(c * 100 + b * 10 + a);
        lst.add(c * 100 + a * 10 + b);
    }

    public static void remove(List<Integer> lst) { // 去除重复数字
        Set<Integer> set = new HashSet<>(lst);
        lst.removeAll(lst);
        lst = new ArrayList<>(set);
    }

    public static boolean check(String line) { // 判断输入的字符是否为合法的字符：只能为数字和，
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (!(Character.isDigit(ch) || ch == ',')) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();
        String[] numbers = line.split(",");
        if (!check(line) || numbers.length != 3) {
            System.out.println(-1);
            return;
        }
        int a = 0, b = 0, c = 0;
        try {
            a = Integer.parseInt(numbers[0]);
            b = Integer.parseInt(numbers[1]);
            c = Integer.parseInt(numbers[2]);
        } catch (Exception ex) {
            System.out.println(-1);
            return;
        }

        // 检查输入是否合法
        if (a <= 0 || a > 9 || b <= 0 || b > 9 || c <= 0 || c > 9) {
            System.out.println(-1);
            return;
        }

        Set<Integer> s = new HashSet<Integer>(); // 判断是否有同时存在2和5、6和9的情况
        s.add(a);
        s.add(b);
        s.add(c);
        if (s.size() != 3 || (s.contains(2) && s.contains(5)) || (s.contains(6) && s.contains(9))) {
            System.out.println(-1);
            return;
        }

        int max = Math.max(a, Math.max(c, b));

        List<Integer> lst = new ArrayList<>();

        addThreeNumbers(lst, a, b, c);
        // 对2和5、6和9的转换
        if (a == 2 || a == 5) {
            addThreeNumbers(lst, 7 - a, b, c);
        }
        if (b == 2 || b == 5) {
            addThreeNumbers(lst, a, 7 - b, c);
        }
        if (c == 2 || c == 5) {
            addThreeNumbers(lst, a, b, 7 - c);
        }

        if (a == 6 || a == 9) {
            addThreeNumbers(lst, 15 - a, b, c);
        }
        if (b == 6 || b == 9) {
            addThreeNumbers(lst, a, 15 - b, c);
        }
        if (c == 6 || c == 9) {
            addThreeNumbers(lst, a, b, 15 - c);
        }

        // 考虑2和6、9或者5和6、9同时存在的情况
        if ((s.contains(2) || s.contains(5)) && (s.contains(6) || s.contains(9))) {
            int x = s.contains(2) ? 2 : 5;
            int y = s.contains(6) ? 6 : 9;
            int z = a + b + c - x - y;
            addThreeNumbers(lst, 7 - x, 15 - y, z);
        }

        // 去除重复元素
        Set<Integer> set = new HashSet<>(lst);
        lst.removeAll(lst);
        lst = new ArrayList<>(set);

        // 排序
        Collections.sort(lst);

        // 获取最大值位置上的数据
        System.out.println(lst.get(max - 1));
    }
}
