package com.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestMain {

    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = sc.readLine()) != null) {
            // 输入的链表节点的个数
            int count = Integer.valueOf(str);

            // 链表数据
            String[] strArr = sc.readLine().split(" ");
            // 倒数的节点数
            int find = Integer.valueOf(sc.readLine());

            if (find == 0) {
                System.out.println(0);
            } else {
                System.out.println(strArr[count - find]);
            }
        }

    }
}
