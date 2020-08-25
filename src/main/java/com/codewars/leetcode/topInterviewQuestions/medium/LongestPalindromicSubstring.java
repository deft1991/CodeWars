package com.codewars.leetcode.topInterviewQuestions.medium;

/*
 * Created by sgolitsyn on 8/18/20
 *
 Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring longest = new LongestPalindromicSubstring();

        System.out.println(longest.longestPalindrome("babad")); // bab or aba
        System.out.println(longest.longestPalindrome("cbbd")); // bb
        System.out.println(longest.longestPalindrome("bb")); // bb
        System.out.println(longest.longestPalindrome("aaaa")); // aaaa
        System.out.println(longest.longestPalindrome("abcda")); // a
    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        } else if (s.length() == 1) {
            return s;

        } else if (s.length() == 2) {
            if (s.charAt(0) != s.charAt(1)) {
                return String.valueOf(s.charAt(0));
            } else {
                return s;
            }
        }

        String longest = "";
        String rez = "";

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {
            int start = i;
            int end = i + 1;

            while (end < chars.length && chars[start] == chars[end]) {
                end++;
                rez = s.substring(start, end);
            }
            longest = rez.length() > longest.length() ? rez : longest;

            if (end < chars.length && chars[start] != chars[end]) {
                start--;
            }

            while (start >= 0 && end < chars.length) {
                if (chars[start] == chars[end]) {
                    rez = s.substring(start, end + 1);
                    start--;
                    end++;
                } else {
                    break;
                }

            }
            longest = rez.length() > longest.length() ? rez : longest;
        }
        return longest.isEmpty() ? String.valueOf(s.charAt(0)) : longest;
    }
}
