package com.nowcoder;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @ClassName PokerDemo
 * @Description 模拟斗地主洗牌发牌
 * @Author Taowd
 * @Version V1.0
 */
public class PokerDemo {

    public static void main(String[] args) {
        //创建牌盒
        ArrayList<String> array = new ArrayList<String>();

        String[] colors = {"♥", "♠", "♣", "♦"};
        String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        //装牌
        for (String color : colors) {
            for (String number : numbers) {
                array.add(color.concat(number));
            }
        }
        array.add("大王");
        array.add("小王");
        //洗牌
        Collections.shuffle(array);

        System.out.println(array);

        //发牌
        ArrayList<String> zhangSan = new ArrayList<String>();
        ArrayList<String> liSi = new ArrayList<String>();
        ArrayList<String> wagWu = new ArrayList<String>();
        ArrayList<String> diPai = new ArrayList<String>();

        for (int x = 0; x < array.size(); x++) {
            if (x >= array.size() - 3) {
                diPai.add(array.get(x));
            } else if (x % 3 == 0) {
                zhangSan.add(array.get(x));
            } else if (x % 3 == 1) {
                liSi.add(array.get(x));
            } else if (x % 3 == 2) {
                wagWu.add(array.get(x));
            }
        }

        //看牌
        System.out.println("zhangSan:" + zhangSan);
        System.out.println("    liSi:" + liSi);
        System.out.println("   wagWu:" + wagWu);
        System.out.println("   diPai:" + diPai);

    }
}
