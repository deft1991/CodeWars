package com.codewars.neetcode.twoPointers;

/**
 * @author Sergey Golitsyn
 * created on 06.12.2022
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        System.out.println(v.isPalindrome("a"));
        System.out.println(v.isPalindrome("ab"));
        System.out.println(v.isPalindrome("0p"));
        System.out.println(v.isPalindrome("abc"));
        System.out.println(v.isPalindrome("abcba"));
        System.out.println(v.isPalindrome("abba"));
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();
        while (start < end) {
            char a = s.charAt(start);
            char b = s.charAt(end);
            if (!Character.isLetterOrDigit(a)) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(b)) {
                end--;
                continue;
            }

            if (a != b) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
