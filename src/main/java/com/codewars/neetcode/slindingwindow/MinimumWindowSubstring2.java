package com.codewars.neetcode.slindingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Sergey Golitsyn
 * created on 25.07.2023
 */
public class MinimumWindowSubstring2 {

    public static void main(String[] args) {
        MinimumWindowSubstring2 m = new MinimumWindowSubstring2();
        System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(m.minWindow("a", "a"));
        System.out.println(m.minWindow("a", "aa"));
        System.out.println(m.minWindow("aa", "aa"));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> dict = new HashMap<>();
        Map<Character, Integer> currentMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            dict.put(c, dict.getOrDefault(c, 0) + 1);
        }

        int baseCount = dict.keySet().size();
        int curCount = 0;
        int start = 0;
        int end = 0;

        int startP = -1;
        int endP = -1;
        int minL = Integer.MAX_VALUE;

        while (end < s.length()) {
            char cur = s.charAt(end);
            if (dict.containsKey(cur)) {
                currentMap.put(cur, currentMap.getOrDefault(cur, 0) + 1);
                // increase count
                if (Objects.equals(currentMap.get(cur), dict.get(cur))) {
                    curCount++;
                }

                // if have word
                while (curCount == baseCount) {
                    // calculate borders
                    if (minL > end - start) {
                        startP = start;
                        endP = end;
                        minL = Math.min(minL, endP - startP);
                    }

                    // move start pointer
                    char st = s.charAt(start);
                    if (dict.containsKey(st)) {
                        currentMap.put(st, currentMap.getOrDefault(st, 0) - 1);
                        if (currentMap.get(st) < dict.get(st)) {
                            curCount--;
                        }
                    }
                    start++;
                }
            }
            end++;
        }

        return startP == -1 ? "" : s.substring(startP, endP+1);
    }
}
