package com.codewars.GRIND75;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 10.11.2023
 */
public class WordBreak {

    public static void main(String[] args) {
        WordBreak w = new WordBreak();
        System.out.println(w.wordBreak("leetcode", List.of("leet", "code")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[s.length()+1];
        q.add(0);

        while (!q.isEmpty()){
            int start = q.poll();

            if (start == s.length()){
                return true;
            }

            for(int end = start + 1; end <= s.length(); end++){
                String sub = s.substring(start, end);
                if (visited[end]){
                    continue;
                }
                if (set.contains(sub)){
                    visited[end] = true;
                    q.add(end);
                }
            }
        }
        return false;
    }
}
