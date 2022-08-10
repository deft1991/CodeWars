package com.codewars.leetcode.days21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 16.03.2022
 */
public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        FindAllAnagramsInAString f = new FindAllAnagramsInAString();

//        System.out.println(f.findAnagrams("abab", "ab"));
        System.out.println(f.findAnagrams("cbaebabacd", "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> rez = new ArrayList<>();
        int[] dict = new int[256];
        for (char c : p.toCharArray()) {
            dict[c]++;
        }

        int cntMatch = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char sChar = s.charAt(right);
            dict[sChar]--;
            if (dict[sChar] + 1 > 0) {
                cntMatch++;
            }
            while (cntMatch == p.length()) {
                if (right - left + 1 == p.length()) {
                    rez.add(left);
                }
                sChar = s.charAt(left);
                dict[sChar]++;
                if (dict[sChar] - 1 >= 0) {
                    cntMatch--;
                }
                left++;
            }
        }
        return rez;
    }
}
