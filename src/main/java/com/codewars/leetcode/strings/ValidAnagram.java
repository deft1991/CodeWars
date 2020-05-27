package com.codewars.leetcode.strings;


/*
 * Created by sgolitsyn on 5/25/20
 */
public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome(".a"));
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        String[] split = s.split("");
        int start = 0;
        int end = split.length - 1;
        if (split.length == 1) {
            return true;
        }
        while (start < end) {
            if (!split[start].equalsIgnoreCase(split[end])) {
                return false;
            }
            end--;
            start++;
        }
        return true;
    }
}
