package com.codewars.leetcode.handbook;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by sgolitsyn on 7/28/20
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring wind = new MinimumWindowSubstring();

        System.out.println(wind.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(wind.minWindow("A", "B"));
    }

    public String minWindow(String s, String t) {

        int startWindow = 0;
        int patternLength = t.length();
        int minTmpWindowLength = s.length();
        int minStart = 0;
        int minEnd = s.length();
        boolean isAllChars = false;
        boolean isPersist = false;

        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> patternMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            patternMap.merge(c, 1, Integer::sum);
        }

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (patternMap.containsKey(currentChar)) {
                patternMap.merge(currentChar, 1, (a, b) -> a - b);
                patternLength--;
            }

            if (patternLength <= 0) {
                isAllChars = checkIsAllChars(patternMap);
            }
            while (patternLength <= 0 && isAllChars) {
                char startChar = s.charAt(startWindow);
                isPersist = true;
                if (patternMap.containsKey(startChar)) {
                    patternLength++;
                    patternMap.merge(startChar, 1, Integer::sum);
                    isAllChars = checkIsAllChars(patternMap);
                    if (minTmpWindowLength > i - startWindow){
                        minStart = startWindow;
                        minEnd = i + 1;
                        minTmpWindowLength = minEnd - minStart;
                    }
                }
                startWindow++;
            }
        }

        return isPersist ? s.substring(minStart, minEnd) : "";
    }

    private boolean checkIsAllChars(Map<Character, Integer> patternMap) {
        for (Integer value : patternMap.values()) {
            if (value > 0) {
                return false;
            }
        }
        return true;
    }

}
