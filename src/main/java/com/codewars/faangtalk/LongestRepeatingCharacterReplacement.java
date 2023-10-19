package com.codewars.faangtalk;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 13.09.2023
 */
public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement l = new LongestRepeatingCharacterReplacement();
//        System.out.println(l.characterReplacement("ABAB", 2));
        System.out.println(l.characterReplacement("AABABBA", 1));
    }

    public int characterReplacement2(String s, int k) {
        int start = 0;
        int end = 0;
        int[] chars = new int[26];
        int longestSubstringLength = end + 1 - start;
        int maxFreq = 0;

        while(end < s.length()){
            char cur = s.charAt(end);
            chars[cur - 'A']++;
            maxFreq = Math.max(maxFreq, chars[cur - 'A']);

            if(!(end + 1 - start - maxFreq <= k)){
                //invalid
                char st = s.charAt(start);
                chars[st - 'A']--;
                start++;
            }
            longestSubstringLength = end + 1 - start;
            end ++;
        }
        return longestSubstringLength;
    }

    public int characterReplacement(String s, int k) {
        int start = 0;
        int end = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int longestSubstringLength = end + 1 - start;
        int maxFreq = 0;

        while(end < s.length()){
            char cur = s.charAt(end);
            freqMap.put(cur, freqMap.getOrDefault(cur, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(cur));

            if(end + 1 - start - maxFreq <= k){
                // valid
            } else {
                //invalid
                char st = s.charAt(start);
                freqMap.put(cur, freqMap.get(cur) - 1);
                start++;
            }
            longestSubstringLength = end + 1 - start;
            end ++;
        }
        return longestSubstringLength;
    }
}
