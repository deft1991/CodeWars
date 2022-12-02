package com.codewars.leetcode.problems.medium;

/**
 * @author Sergey Golitsyn
 * created on 15.10.2022
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring lp = new LongestPalindromicSubstring();
//        System.out.println(lp.longestPalindrome("a")); //a
//        System.out.println(lp.longestPalindrome("aa"));//a
//        System.out.println(lp.longestPalindrome("aaa"));//a
        System.out.println(lp.longestPalindrome("aba"));//a
//        System.out.println(lp.longestPalindrome("ab"));//a
//        System.out.println(lp.longestPalindrome("aba"));//aba
//        System.out.println(lp.longestPalindrome("abac"));//aba
//        System.out.println(lp.longestPalindrome("caba")); // aba
//        System.out.println(lp.longestPalindrome("cabac")); // cabac
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        int palindromeStartsAt = 0;
        int maxLen = 0;

        /*
         * dp[i][j] indicates whether substring s starting at index i and ending at j is palindrome
         */
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) { // keep increasing the possible palindrome string
            for (int j = i; j < n; j++) { // find the max palindrome within this window of (i,j)

                //check if substring between (i,j) is palindrome
                dp[i][j] = (s.charAt(i) == s.charAt(j)) // chars at i and j should match
                        &&
                        (j - i < 3  // if window is less than or equal to 3, just end chars should match
                                || dp[i + 1][j - 1]); // if window is > 3, substring (i+1, j-1) should be palindrome too

                /*
                 * update max palindrome string
                 */
                if (dp[i][j] && (j - i + 1 > maxLen)) {
                    palindromeStartsAt = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(palindromeStartsAt, palindromeStartsAt + maxLen);
    }

    public String longestPalindrome2(String s) {
        int max = 1;
        String maxStr = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String s1 = s.substring(j, i + 1);
                if (isPalindrome(s1)) {
                    int length = i - j + 1;
                    if (max < length) {
                        max = length;
                        maxStr = s.substring(j, i + 1);
                    }

                }
            }
        }
        return maxStr;
    }

    private boolean isPalindrome(String s1) {
        int start = 0;
        int end = s1.length() - 1;
        while (start < end) {
            if (s1.charAt(start) != s1.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
