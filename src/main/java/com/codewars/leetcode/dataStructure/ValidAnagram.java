package com.codewars.leetcode.dataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 07.04.2022
 */
public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram v = new ValidAnagram();
        System.out.println(v.isAnagram("a", "a")); // true
        System.out.println(v.isAnagram("ab", "a")); // false
        System.out.println(v.isAnagram("ab", "ba")); // true
        System.out.println(v.isAnagram("aab", "baa")); // true
        System.out.println(v.isAnagram("aaac", "ccaa")); // false
        System.out.println(v.isAnagram("aaac", "ccac")); // false
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (map.get(c) == null || map.get(c) <= 0) {
                return false;
            }
            map.put(c, map.getOrDefault(c, 0) - 1);

        }
        return true;
    }
}
