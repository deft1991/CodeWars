package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 19.03.2021
 */
public class SplitStringBalancedStrings {

    public static void main(String[] args) {
        SplitStringBalancedStrings s = new SplitStringBalancedStrings();

        System.out.println(s.balancedStringSplit("RLRRLLRLRL")); // 4
        System.out.println(s.balancedStringSplit("RLLLLRRRLR")); // 3
        System.out.println(s.balancedStringSplit("LLLLRRRR")); // 1
        System.out.println(s.balancedStringSplit("RLRRRLLRLL")); // 2
    }

    public int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();

        char startChar = chars[0];
        int count = 1;
        int rez = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == startChar) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                rez++;
                if (i + 1 < chars.length) {
                    startChar = chars[++i];
                    count = 1;
                }
            }
        }
        return rez;
    }
}
