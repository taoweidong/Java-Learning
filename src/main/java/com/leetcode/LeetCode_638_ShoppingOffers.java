package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_638_ShoppingOffers {
    public static void main(String[] args) {
        List<Integer> price = new ArrayList<>();
        price.add(2);
        price.add(5);
        List<List<Integer>> special = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        item.add(3);
        item.add(0);
        item.add(5);

        List<Integer> item2 = new ArrayList<>();
        item2.add(1);
        item2.add(2);
        item2.add(10);
        special.add(item);
        special.add(item2);

        List<Integer> needs = new ArrayList<>();
        needs.add(3);
        needs.add(2);

        System.out.println(new LeetCode_638_ShoppingOffers().shoppingOffers(price, special, needs));

    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

        return dfs(price, special, needs);
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int result = 0;
        // 当需要need物品时，全部用原价购买
        for (int i = 0; i < needs.size(); i++) {
            result += needs.get(i) * price.get(i);
        }

        // 尝试用大礼包购买
        for (List<Integer> item : special) {
            List<Integer> clone = new ArrayList<>(needs);

            int i = 0;
            for (i = 0; i < needs.size(); i++) {
                int diff = clone.get(i) - item.get(i);
                if (diff < 0) {
                    // 你不能购买超出购物清单指定数量的物品，即使那样会降低整体价格。任意大礼包可无限次购买。
                    break;
                }
                // 剩余需要的物品数量
                clone.set(i, diff);
            }

            if (i == needs.size()) {
                // 剩余需要购买的物品
                result = Math.min(result, item.get(i) + dfs(price, special, clone));
            }
        }

        return result;
    }
}
