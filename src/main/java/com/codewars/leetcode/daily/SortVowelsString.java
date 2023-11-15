package com.codewars.leetcode.daily;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 13.11.2023
 */
public class SortVowelsString {

    public static void main(String[] args) {
        SortVowelsString s = new SortVowelsString();
        System.out.println(s.sortVowels("lEetcOde"));
        System.out.println(s.sortVowels("lYmpH"));
    }

    public String sortVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int[] count = new int[1000];
        for (char c : s.toCharArray()){
            if (vowels.contains(Character.toLowerCase(c))){
                count[c - 'A']++;
            }
        }

        // Sorted string having all the vowels.
        String sortedVowel = "AEIOUaeiou";

        StringBuilder sb = new StringBuilder();
        int reader = 0;
        for (char c : s.toCharArray()){
            if (!vowels.contains(Character.toLowerCase(c))){
                sb.append(c);
            } else {

                while(count[sortedVowel.charAt(reader) - 'A'] == 0){
                    reader ++;
                }
                sb.append(sortedVowel.charAt(reader));
                count[sortedVowel.charAt(reader) - 'A']--;
            }
        }
        return sb.toString();
    }
}
