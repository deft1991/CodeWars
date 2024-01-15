package com.codewars.leetcode.daily;

/**
 * @author Sergey Golitsyn
 * created on 13.01.2024
 */
public class MinimumNumberStepsMakeTwoStringsAnagram {

    public static void main(String[] args) {
        MinimumNumberStepsMakeTwoStringsAnagram m = new MinimumNumberStepsMakeTwoStringsAnagram();
        System.out.println(m.minSteps("leetcode", "practice"));
    }

    public int minSteps(String s, String t) {
        int[] chars = new int[26];

        for(char c : s.toCharArray()){
            chars[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            chars[c - 'a']--;
        }
        int rez = 0;
        for(int i : chars){
            if(i > 0){
                rez+= i;
            }
        }
        return rez;
    }
}
