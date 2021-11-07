package com.codewars.crackingcodeinterview;

/**
 * @author Sergey Golitsyn
 * created on 08.06.2021
 */
public class WordDistance {

    public static void main(String[] args) {
        WordDistance wd = new WordDistance();
        System.out.println(wd.wordDistance(new String[]{"a", "b", "d", "c", "e", "a"}, "a", "c")); // 2
        System.out.println(wd.wordDistance(new String[]{"a", "c"}, "a", "c")); // 1
    }

    private int wordDistance(String[] words, String word1, String word2) {

        int minPos = Integer.MAX_VALUE / 2;
        int word1Pos = -minPos;
        int word2Pos = -minPos;

        for (int i = 0; i < words.length; i++) {

            if (word1.equals(words[i])) {
                word1Pos = i;

                int distance = word1Pos - word2Pos;
                if (distance < minPos) {
                    minPos = distance;
                }

            } else if (word2.equals(words[i])) {
                word2Pos = i;

                int distance = word2Pos - word1Pos;
                if (distance < minPos) {
                    minPos = distance;
                }
            }
        }
        return minPos;
    }
}
