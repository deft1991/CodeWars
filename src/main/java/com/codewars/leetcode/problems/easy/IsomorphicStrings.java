package com.codewars.leetcode.problems.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 18.08.2022
 */
public class IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("bbbaaaba", "aaabbbba"));
        System.out.println(isIsomorphic("egg", "add"));

    }

    public static boolean isIsomorphic(String s, String t) {

        int[] sChar = new int[26];
        int[] tChar = new int[26];
        Arrays.fill(sChar, -1);
        Arrays.fill(tChar, -1);

        for(int  i = 0; i < s.length(); i++){
            int sCharIdx = s.charAt(i) - 'a';
            int stCharIdx = t.charAt(i) - 'a';
            if (sChar[sCharIdx] == -1 && tChar[stCharIdx] == -1){
                sChar[sCharIdx] = stCharIdx;
                tChar[stCharIdx] = sCharIdx;
            } else if (sChar[sCharIdx] != stCharIdx || tChar[stCharIdx] != sCharIdx) {
                return false;
            }
        }
        return true;
    }
}
