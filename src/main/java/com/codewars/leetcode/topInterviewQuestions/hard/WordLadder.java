package com.codewars.leetcode.topInterviewQuestions.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * Created by sgolitsyn on 8/27/20
 */
public class WordLadder {

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();


        System.out.println(
                wordLadder.ladderLength(
                        "hit",
                        "cog",
                        Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> allComboDict = new HashMap<>();
        int L = beginWord.length();

        /* prepare all combo dictionary
        Example
        for hot we will have
        *ot
        h*t
        ho*
         */
        wordList.forEach(currentWord -> {
            for (int i = 0; i < L; i++) {
                // prepare
                String newWord = currentWord.substring(0, i) + "*" + currentWord.substring(i + 1, L);
                List<String> stringList = allComboDict.getOrDefault(newWord, new ArrayList<>());
                stringList.add(currentWord);
                allComboDict.put(newWord, stringList);
            }
        });

        /*
        Now let`s prepare queue and make BFS.
        Also prepare Visit map for check visited words
         */

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Map<String, Boolean> visited = new HashMap<>();

        queue.add(new Pair(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getKey();
            Integer level = pair.getValue();


            /*
            Prepare transformation words for current word
            and search tranformation in dictionary
             */
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, L);

                List<String> stringList = allComboDict.getOrDefault(newWord, new ArrayList<>());

                for (String adjacentWord : stringList) {
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    } else {
                        if (!visited.containsKey(adjacentWord)) {
                            visited.put(adjacentWord, true);
                            queue.add(new Pair<>(adjacentWord, level + 1));
                        }
                    }
                }
            }
        }
        return 0;
    }

    private static class Pair<T, E> {

        private final T key;
        private final E value;

        Pair(T key, E value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public E getValue() {
            return value;
        }
    }
}

