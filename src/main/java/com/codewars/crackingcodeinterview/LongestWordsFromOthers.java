package com.codewars.crackingcodeinterview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 09.06.2021
 * <p>
 * Write a program to find the longest word made of other words
 */
public class LongestWordsFromOthers {

    public static void main(String[] args) {
        LongestWordsFromOthers lwfo = new LongestWordsFromOthers();

        System.out.println(lwfo.longestWord(new String[]{"a", "b", "c", "ab", "abc"}));
    }

    private String longestWord(String[] arr) {
        Map<String, Boolean> dictionary = new HashMap<>();

        for (String str : arr) {
            dictionary.put(str, true);
        }

        Arrays.sort(arr, Comparator.comparingInt(String::length));

        for (String str : arr) {

            for (int i = 1; i < str.length(); i++) {

                if (isCompoundString(str, true, dictionary)) {
                    return str;
                }
            }

        }
        return "";
    }

    private boolean isCompoundString(String str, boolean isOriginal, Map<String, Boolean> dictionary) {

        if (dictionary.containsKey(str) && !isOriginal) {
            return true;
        }

        for (int i = 1; i < str.length(); i++) {

            String left = str.substring(0, i);
            String right = str.substring(i);

            if (dictionary.containsKey(left) && isCompoundString(right, false, dictionary)) {
                return true;
            }
        }
        return false;

    }

}
