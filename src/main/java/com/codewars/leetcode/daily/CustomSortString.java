package com.codewars.leetcode.daily;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 11.03.2024
 */
public class CustomSortString {

    public static void main(String[] args) {
        CustomSortString c = new CustomSortString();
        System.out.println(c.customSortString("cba", "abcd"));
        System.out.println(c.customSortString("bcafg", "abcd"));
    }

    public String customSortString(String order, String s) {
        int[] chars = new int[26];
        for(int i = 0; i < 26; i++){
            chars[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < order.length(); i++){
            char cur = order.charAt(i);
            chars[cur - 'a'] = i;
        }
        Character[] word = new Character[s.length()];
        int i = 0;
        for (char c : s.toCharArray()){
            word[i++] = c;
        }
        Arrays.sort(word, (a, b) -> {
           return Integer.compare(chars[a - 'a'], chars[b - 'a']);
        });
        StringBuilder sb = new StringBuilder();
        for (Character c : word){
            sb.append(c);
        }
        return sb.toString();
    }
}
