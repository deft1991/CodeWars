package com.codewars.leetcode.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 20.11.2023
 */
public class MinimumAmountTimeCollectGarbage {

    public static void main(String[] args) {
        MinimumAmountTimeCollectGarbage m = new MinimumAmountTimeCollectGarbage();
        System.out.println(m.garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3})); // 21
        System.out.println(m.garbageCollection(new String[]{"MMM","PGM","GP"}, new int[]{3,10})); // 37
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        Map<String, Integer> garbageCount = new HashMap<>();

        for (String s : garbage) {
            for (char c : s.toCharArray()) {
                garbageCount.put(String.valueOf(c), garbageCount.getOrDefault(String.valueOf(c), 0) + 1);
            }
        }

        int metal = 0;
        int paper = 0;
        int glass = 0;

        for (int i = 0; i < garbage.length; i++) {
            String gar = garbage[i];

            for (char c : gar.toCharArray()) {
                switch (c) {
                    case 'M':
                        metal++;
                        break;
                    case 'P':
                        paper++;
                        break;
                    case 'G':
                        glass++;
                        break;
                }
                garbageCount.put(String.valueOf(c), garbageCount.get(String.valueOf(c)) - 1);
            }
            if (i < travel.length) {
                String m = String.valueOf('M');
                String p = String.valueOf('P');
                String g = String.valueOf('G');
                if (garbageCount.containsKey(m) && garbageCount.get(m) > 0) {
                    metal += travel[i];
                }
                if (garbageCount.containsKey(p) && garbageCount.get(p) > 0) {
                    paper += travel[i];
                }
                if (garbageCount.containsKey(g) && garbageCount.get(g) > 0) {
                    glass += travel[i];
                }
            }
        }
        return metal + paper + glass;
    }
}
