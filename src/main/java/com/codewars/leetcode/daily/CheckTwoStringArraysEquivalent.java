package com.codewars.leetcode.daily;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 01.12.2023
 */
public class CheckTwoStringArraysEquivalent {

    public static void main(String[] args) {
        CheckTwoStringArraysEquivalent c = new CheckTwoStringArraysEquivalent();
        System.out.println(c.arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        for(String s : word1){
            sb1.append(s);
        }
        StringBuilder sb2 = new StringBuilder();
        for(String s : word2){
            sb2.append(s);
        }

        return sb1.compareTo(sb2) == 0;
    }
}
