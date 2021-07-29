package com;

public class PrintHeart {
    public static void main(String[] args) {
        System.out.println(printHeart("*"));
    }

    private static String printHeart(String input) {
        int[] array = {0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 4, 5, 2, 3, 4, 1, 0, 1, 0, 0,
            0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        StringBuffer pi = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            if (i % 7 == 0)
                pi.append("\n");
            if (array[i] == 0)
                pi.append("   ");
            else if (array[i] == 4)
                pi.append("  ");
            else if (array[i] == 5)
                pi.append(" 唐 ");
            else if (array[i] == 2)
                pi.append(" 锦 ");
            else if (array[i] == 3)
                pi.append(" 锦 ");
            else
                pi.append("  " + input);
        }
        return pi.toString();
    }
}
