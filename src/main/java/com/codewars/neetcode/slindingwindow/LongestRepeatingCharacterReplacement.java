package com.codewars.neetcode.slindingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 14.12.2022
 */
public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement l = new LongestRepeatingCharacterReplacement();
//        System.out.println(l.characterReplacement("ABAB", 2)); // 4
        System.out.println(l.characterReplacement("AABABBA", 1)); // 4
    }

    public int characterReplacement(String s, int k) {

        int start = 0;
        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        int maxFreq = 0;
        for (int end = 0; end < s.length(); end++) {
            char cur = s.charAt(end);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            maxFreq = Math.max(maxFreq, maxCharLength(map));
            while ((end - start + 1) - maxFreq > k) {
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                start++;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    private int maxCharLength(Map<Character, Integer> map) {
        int max = 0;
        for (Integer i : map.values()) {
            max = Math.max(max, i);
        }
        return max;
    }

}
