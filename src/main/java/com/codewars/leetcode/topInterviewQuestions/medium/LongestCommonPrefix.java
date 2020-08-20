package com.codewars.leetcode.topInterviewQuestions.medium;

/*
 * Created by sgolitsyn on 8/19/20
 *
 Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix longest = new LongestCommonPrefix();

        System.out.println(longest.longestCommonPrefix(new String[]{"flower","flow","flight"})); //fl
        System.out.println(longest.longestCommonPrefix(new String[]{"dog","racecar","car"})); // ""
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }
        String longest = strs[0];

        for (String current : strs) {

            while (!current.startsWith(longest) || longest.length() > current.length()) {
                longest = longest.substring(0, longest.length() - 1);
            }
        }

        return longest;
    }
}
