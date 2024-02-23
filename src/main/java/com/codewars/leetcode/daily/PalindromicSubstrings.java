package com.codewars.leetcode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 10.02.2024
 */
public class PalindromicSubstrings {

    public static void main(String[] args) {
        PalindromicSubstrings p = new PalindromicSubstrings();
//        System.out.println(p.countSubstrings("abc"));
        System.out.println(p.countSubstrings("aaa"));
    }

    int rez = 0;
    public int countSubstrings(String s) {
        rez = 0;
        int[] count = new int[26];

        backtrack(s, count, 0);
        return rez;
    }

    private void backtrack(String s, int[] count, int start){
        if(isPalindrome(count)){
            rez++;
        }
        for(int i = start; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            backtrack(s, count, i+1);
            count[s.charAt(i) - 'a']--;
        }
    }

    private boolean isPalindrome(int[] count){
        int isOdd = 0;
        boolean isNull = true;
        for(int c : count){
            if (c > 0){
                isNull = false;
            }
            if(c%2 != 0){
                isOdd++;
            }
        }
        return !isNull && isOdd <= 1;
    }
}
