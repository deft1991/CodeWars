package com.codewars.leetcode.topInterviewQuestions.medium;

import java.util.Arrays;

/*
 * Created by sgolitsyn on 8/14/20
 *
 Given a string, find the length of the longest substring without repeating characters.

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


 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longest = new LongestSubstringWithoutRepeatingCharacters();


        System.out.println(longest.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(longest.lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(longest.lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(longest.lengthOfLongestSubstring("  ")); // 1
        System.out.println(longest.lengthOfLongestSubstring("dvdf")); // 3
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println(longest.lengthOfLongestSubstring2("abcabcbb")); // 3
        System.out.println(longest.lengthOfLongestSubstring2("bbbbb")); // 1
        System.out.println(longest.lengthOfLongestSubstring2("pwwkew")); // 3
        System.out.println(longest.lengthOfLongestSubstring2("  ")); // 1
        System.out.println(longest.lengthOfLongestSubstring2("dvdf")); // 3
    }

    public int lengthOfLongestSubstring(String s) {

        int startWindow = 0;

        if (s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int count = 0;
        int maxCount = 0;
        int[] alphabet = new int[1024];

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            alphabet[currentChar - ' ']++;
            count++;
            if (alphabet[currentChar - ' '] > 1) {
                while (alphabet[currentChar - ' '] > 1) {
                    char startC = s.charAt(startWindow);
                    count--;
                    alphabet[startC - ' ']--;
                    startWindow++;
                }

            }
            maxCount = Math.max(maxCount, count);
        }
        return Math.max(maxCount, count);
    }

    public int lengthOfLongestSubstring2(String s) {

        if (s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int count = 0;
        int maxCount = 0;
        int[] alphabet = new int[1024];
        Arrays.fill(alphabet, -1);

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (alphabet[currentChar - ' '] == -1){
               count += 1;
            } else {
                count = Math.min(i - alphabet[currentChar - ' '], count + 1);
            }
            maxCount = Math.max(maxCount, count);
            alphabet[currentChar - ' '] = i;

        }
        return maxCount;
    }
}
