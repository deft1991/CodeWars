package com.codewars.leetcode.problems.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 06.08.2022
 */
public class ReverseVowelsOfString {

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello")); // holle
        System.out.println(reverseVowels("ae"));// ea
        System.out.println(reverseVowels("aaee"));// eeaa
        System.out.println(reverseVowels("leetcode"));// leotcede
        System.out.println(reverseVowels("aA"));// Aa
    }

    public static String reverseVowels(String s) {
        Set<Character> dict = new HashSet<>();
        dict.add('a');
        dict.add('A');
        dict.add('e');
        dict.add('E');
        dict.add('i');
        dict.add('I');
        dict.add('o');
        dict.add('O');
        dict.add('u');
        dict.add('U');

        int reader = 0;
        int writer = s.length() - 1;

        StringBuilder sb = new StringBuilder(s);
        while (reader < writer) {
            if(!dict.contains(s.charAt(reader))){
                reader ++;
            }
            if (!dict.contains(s.charAt(writer))){
                writer--;
            }
            if (dict.contains(s.charAt(reader)) && dict.contains(s.charAt(writer))){
                char tmp = s.charAt(reader);
                sb.setCharAt(reader++, s.charAt(writer));
                sb.setCharAt(writer--, tmp);
            }
        }
        return sb.toString();
    }
}
