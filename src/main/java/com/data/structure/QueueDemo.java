package com.data.structure;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 队列：先进先出
 */
public class QueueDemo {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(2);
        list.add(8);
        list.add(67);
        list.add(233);

        System.out.println(JSON.toJSONString(list));
        System.out.println(Collections.min(list));

        System.out.println("***********************");
        list.set(1, 55);
        System.out.println(JSON.toJSONString(list));
        System.out.println(Collections.min(list));

    }

}
