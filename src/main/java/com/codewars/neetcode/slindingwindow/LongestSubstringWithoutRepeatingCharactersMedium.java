package com.codewars.neetcode.slindingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 12.12.2022
 */
public class LongestSubstringWithoutRepeatingCharactersMedium {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharactersMedium l = new LongestSubstringWithoutRepeatingCharactersMedium();
        System.out.println(l.lengthOfLongestSubstring("abc")); // 3
        System.out.println(l.lengthOfLongestSubstring("abca")); // 3
        System.out.println(l.lengthOfLongestSubstring("abccd")); // 3
        System.out.println(l.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(l.lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(l.lengthOfLongestSubstring("pwwkew")); // 3
    }

    public int lengthOfLongestSubstringOld(String s) {
        int[] dict = new int[128];

        int max = 0;
        int curMax = 0;
        int start = 0;
        int skip = 0;

        while(start < s.length()){
            int idx = s.charAt(start) - 'a';
            if (dict[idx] == 0){
                dict[idx] = 1;
                start++;
                curMax++;
            } else {
                max = Math.max(max, curMax);
                int skipIdx = s.charAt(skip) - 'a';
                dict[skipIdx] = 0;
                skip++;
                curMax--;
            }
        }
        return Math.max(max, curMax);
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> dict = new HashSet<>();
        int rez = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++){
            while(dict.contains(s.charAt(right))){
                dict.remove(s.charAt(left));
                left++;
            }
            dict.add(s.charAt(right));
            rez = Math.max(rez, right - left + 1);
        }
        return rez;
    }
}
