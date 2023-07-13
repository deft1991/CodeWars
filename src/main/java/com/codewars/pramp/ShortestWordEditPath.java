package com.codewars.pramp;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 01.02.2023
 */
public class ShortestWordEditPath {

    public static void main(String[] args) {
        ShortestWordEditPath s = new ShortestWordEditPath();
//        System.out.println(s.ladderLength("bit", "dog", List.of("but","put","big","pot","pog","dog","lot"))); // 5
        System.out.println(s.ladderLength("hit", "cog", List.of("hot","dot","dog","lot","log","cog"))); // 5
//        System.out.println(s.ladderLength("hit", "cog", List.of("hot","dot","dog","lot","log"))); // 0
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> deepMap = new HashMap<>();


        queue.add(beginWord);
        deepMap.put(beginWord, 1);

        while (!queue.isEmpty()){
            String word = queue.poll();
            int depth = deepMap.get(word);
            if (endWord.equals(word)){
                return deepMap.get(endWord);
            }
            for (String s : wordList){

                if (!visited.contains(s) && word.length() == s.length()){
                    int diff = 0;
                    for (int i = 0; i < s.length(); i++){
                        if (s.charAt(i) != word.charAt(i)){
                            diff += 1;
                        }
                        if (diff == 2){
                            break;
                        }
                    }
                    if (diff == 1){
                        visited.add(s);
                        queue.add(s);
                        deepMap.put(s, depth+1);
                    }
                }
            }
        }
        return 0;
    }
}
