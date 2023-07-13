package com.codewars.neetcode.slindingwindow;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 09.06.2023
 */
public class LongestSubstringWithoutRepeatingCharacters2 {

    public static void main(String[] args) {
    LongestSubstringWithoutRepeatingCharacters2 l = new LongestSubstringWithoutRepeatingCharacters2();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));// 3
        System.out.println(l.lengthOfLongestSubstring("bbbbb"));// 1
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));// 3
    }

    public int lengthOfLongestSubstring(String s) {
        int[] dict = new int[128];
        int start = 0;
        int end = 0;

        int max = 0;
        int curMax = 0;
        while(end < s.length()){
            int idx = s.charAt(end) - ' ';
            if(dict[idx] != 0){
                max = Math.max(max, curMax);
                while(dict[idx] != 0){
                    curMax--;
                    int startIdx = s.charAt(start) - ' ';
                    dict[startIdx]--;
                    start++;
                }
            }
            curMax+= 1;
            dict[idx]++;
            end++;
        }
        max = Math.max(max, curMax);
        return max;
    }
}
