package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 06.02.2021
 */
public class ToLowerCase {

    public static void main(String[] args) {
        System.out.println(toLowerCase("al&phaBET"));
    }

    public static String toLowerCase(String str) {
        char[] chars = str.toCharArray();

        for(int i = 0; i < chars.length; i++) {

            if (chars[i] >= 65 && chars[i] <= 90){
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return String.valueOf(chars);
    }
}
