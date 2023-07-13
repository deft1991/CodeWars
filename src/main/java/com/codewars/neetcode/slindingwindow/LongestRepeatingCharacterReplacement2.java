package com.codewars.neetcode.slindingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 19.06.2023
 */
public class LongestRepeatingCharacterReplacement2 {

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement2 l = new LongestRepeatingCharacterReplacement2();
        System.out.println(l.characterReplacement("ABAB", 2));
        System.out.println(l.characterReplacement("AABABBA", 1));
    }

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();

        int start = 0;
        int max = 0;
        for (int end = 0; end < s.length(); end++) {
            char cur = s.charAt(end);
            freq.put(cur, freq.getOrDefault(cur, 0) + 1);

            int maxFreq = getMaxFreq(freq);
            while (end - start + 1 - maxFreq > k) {
                char startC = s.charAt(start);
                freq.put(startC, freq.get(startC) - 1);
                start++;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    private int getMaxFreq(Map<Character, Integer> freq) {
        int max = 0;
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        return max;
    }
}
