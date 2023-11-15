package com.codewars.leetcode.daily;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 14.11.2023
 */
public class UniqueLength3PalindromicSubsequences {

    public static void main(String[] args) {
        UniqueLength3PalindromicSubsequences u = new UniqueLength3PalindromicSubsequences();
        System.out.println(u.countPalindromicSubsequence("aabca")); // 3
        System.out.println(u.countPalindromicSubsequence("adc")); // 0
        System.out.println(u.countPalindromicSubsequence("bbcbaba")); // 4
    }

    public int countPalindromicSubsequence(String s) {
        int[] start = new int[26];
        int[] end = new int[26];

        for (int i = 0; i < start.length; i++){
            start[i] = -1;
            end[i] = -1;
        }

        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if (start[cur - 'a'] == -1){
                start[cur - 'a'] = i;
            }
            end[cur - 'a'] = i;
        }

        int count = 0;

        for(int i = 0; i < start.length; i++){
            if (start[i] == -1){
                continue;
            }
            Set<Character> set = new HashSet<>();

            for (int j = start[i] + 1; j < end[i]; j++){
                set.add(s.charAt(j));
            }
            count += set.size();

        }
        return count;
    }
}
