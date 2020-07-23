package com.codewars.leetcode.handbook;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by sgolitsyn on 7/23/20
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
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();

        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("aabaab!bb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("nfpdmpi")); // 5
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb")); // 3
    }


    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        } else if (s.trim().isEmpty() || s.length() == 1){
            return 1;
        }
        Map<Character, Integer> charCount = new HashMap<>();
        int maxLength = 0;
        int tmpMax = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++){
            char currentChar = s.charAt(end);

            charCount.merge(currentChar, 1, Integer::sum);
            tmpMax ++;
            if  (charCount.get(s.charAt(end)) == 1){
                maxLength = Math.max(maxLength, tmpMax);
            }
            while(charCount.get(currentChar) > 1){
                char startChar = s.charAt(start);
                charCount.compute(startChar, (k,v) -> v == null ? 1 : v - 1);
                start ++;

                tmpMax --;
                tmpMax = tmpMax <= 0 ? 1 : tmpMax;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return  maxLength;
    }
}
