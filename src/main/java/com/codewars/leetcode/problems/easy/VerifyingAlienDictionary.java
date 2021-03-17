package com.codewars.leetcode.problems.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 16.03.2021
 */
public class VerifyingAlienDictionary {

    public static void main(String[] args) {
        VerifyingAlienDictionary v = new VerifyingAlienDictionary();

        System.out.println(v.isAlienSorted(new String[]{"kuvp", "q"}, "ngxlkthsjuoqcpavbfdermiywz"));
        System.out.println(v.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
//        System.out.println(v.isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
//        System.out.println(v.isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
    }

    public boolean isAlienSorted(String[] words, String order) {

        Map<Character, Integer> orderMap = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            String firstWord = words[i - 1];
            String secondWord = words[i];


            if (!compare(firstWord, secondWord, orderMap)){
                return false;
            }
        }
        return true;
    }

    public boolean compare(String word1, String word2, Map<Character, Integer> indexMap) {
        int min = Math.min(word1.length(), word2.length());
        for (int i = 0; i < min; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                return indexMap.get(word1.charAt(i)) < indexMap.get(word2.charAt(i));
            }
        }
        return word1.length() <= word2.length();
    }
}
