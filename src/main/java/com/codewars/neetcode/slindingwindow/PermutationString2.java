package com.codewars.neetcode.slindingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 22.06.2023
 * <p>
 * <p>
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * <p>
 * In other words, return true if one of s1's permutations is the substring of s2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * <p>
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 */
public class PermutationString2 {

    public static void main(String[] args) {
        PermutationString2 p = new PermutationString2();

        System.out.println(p.checkInclusion("ab", "acadab"));
    }


    /*
    ab

    acadab

[a , b, c, d]

[1 - 1, 1, -1]
[1, ]



     */
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            map.put(c2, map.getOrDefault(c2, 0) - 1);
        }

        int start = 0;
        int end = s1.length();

        while (end < s2.length()){
            if (isEmpty(map)){
                return true;
            }
            char c1 = s2.charAt(start);
            char c2 = s2.charAt(end);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            map.put(c2, map.getOrDefault(c2, 0) - 1);
            start++;
            end++;
        }

        return isEmpty(map);
    }

    private boolean isEmpty(Map<Character, Integer> map) {
        for (int i : map.values()){
            if (i != 0){
                return false;
            }
        }
        return true;
    }
}
