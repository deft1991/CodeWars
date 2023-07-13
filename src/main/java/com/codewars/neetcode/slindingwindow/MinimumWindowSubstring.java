package com.codewars.neetcode.slindingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Sergey Golitsyn
 * created on 16.12.2022
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        System.out.println(m.minWindow("a", "a"));
        System.out.println(m.minWindow("a", "aa"));
        System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(m.minWindow("a", "b"));
        System.out.println(m.minWindow("aqweasdqweasaf", "b"));
        System.out.println(m.minWindow("aa", "aa"));
    }

    public String minWindow(String s, String t) {
        if (t == null || t.equals("") || t.length() > s.length()){
            return "";
        }

        Map<Character, Integer> dict = new HashMap<>();

        int needed = 0;
        for (int i = 0; i < t.length(); i++){
            dict.put(t.charAt(i), dict.getOrDefault(t.charAt(i), 0) + 1);
        }
        needed = dict.values().size();

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int match = 0;
        int max = Integer.MAX_VALUE;
        int[] rezIdx = new int[2];
        boolean isFound = false;
        for (int right = 0; right < s.length(); right++){
            char currentChar = s.charAt(right);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            if (dict.containsKey(currentChar) && Objects.equals(dict.get(currentChar), map.get(currentChar))){
                match++;
            }

            while(match == needed){
                int curLength = right - left + 1;
                if (curLength < max){
                    isFound = true;
                    max = curLength;
                    rezIdx[0] = left;
                    rezIdx[1] = right;
                }
                char currentLeft = s.charAt(left);
                map.put(currentLeft, map.get(currentLeft) - 1);

                if (dict.containsKey(currentLeft) && map.get(currentLeft) < dict.get(currentLeft)) {
                    match--;
                }
                left++;
            }
        }
        return isFound ? s.substring(rezIdx[0], rezIdx[1]+1) : "";
    }
}
