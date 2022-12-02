package com.codewars.leetcode.problems.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 20.10.2022
 */
public class WordBreak {

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreak("a", List.of("a"))); // t
//        System.out.println(wb.wordBreak("leetcode", List.of("leet","code"))); // t
//        System.out.println(wb.wordBreak("leetcode", List.of("leet","coder"))); // f
//        System.out.println(wb.wordBreak("applepenapple", List.of("apple","pen"))); // t
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0){
            return false;
        }
        Set<String> dict = new HashSet<>(wordDict);

        if(dict.contains(s)){
            return true;
        }

        int n = s.length();
        boolean[] dp = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);
                if (dict.contains(sub) && (j == 0 || dp[j-1])){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n-1];
    }
}
