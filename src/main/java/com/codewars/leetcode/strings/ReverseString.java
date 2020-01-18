package com.codewars.leetcode.strings;

import java.util.Arrays;

/*
 * Created by sgolitsyn on 1/13/20
 */
public class ReverseString {

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString.reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            char tmp = s[i];
            s[i] = s[s.length-1 - i];
            s[s.length-1 - i] = tmp;
        }
    }
}
