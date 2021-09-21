package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 841. 钥匙和房间
 */
public class LeetCode_841_CanVisitAllRooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        rooms.add(new ArrayList<>(list1));
        list1.clear();
        list1.add(3);
        list1.add(0);
        list1.add(1);
        rooms.add(new ArrayList<>(list1));
        list1.clear();
        list1.add(2);
        rooms.add(new ArrayList<>(list1));
        list1.clear();
        list1.add(0);
        rooms.add(new ArrayList<>(list1));

        System.out.println(rooms);
        System.out.println("************************************************************");
        System.out.println(new LeetCode_841_CanVisitAllRooms().canVisitAllRooms(rooms));

    }

    int num;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        num = 0;
        boolean[] vis = new boolean[size];
        dfs(rooms, 0, vis);

        return num == size;
    }

    private void dfs(List<List<Integer>> rooms, int x, boolean[] vis) {
        vis[x] = true;
        num++;
        for (Integer item : rooms.get(x)) {
            if (!vis[item]) {
                dfs(rooms, item, vis);
            }
        }
    }
}
