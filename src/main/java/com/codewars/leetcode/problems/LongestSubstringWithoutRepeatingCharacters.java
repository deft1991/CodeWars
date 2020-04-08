package com.codewars.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/*
 * Created by sgolitsyn on 3/30/20
 *
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
//        System.out.println( l.lengthOfLongestSubstring("aab"));
//        System.out.println( l.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println( l.lengthOfLongestSubstring("bbbbb"));
//        System.out.println( l.lengthOfLongestSubstring("pwwkew"));
        System.out.println( l.lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null){
            return 0;
        }
        int rez = 0;
        int current = 0;
        Set<Character> curChars = new HashSet<>();

        char[] chars = s.toCharArray();

        for (Character c : chars) {

            if (curChars.contains(c)) {
                rez = Math.max(rez, current);
                current = 1;
                curChars.clear();
                curChars.add(c);
            } else {
                current += 1;
                curChars.add(c);
            }
        }
        rez = Math.max(rez, current);
        return rez;
    }
}
