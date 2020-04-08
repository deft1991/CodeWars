package com.codewars.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * Created by sgolitsyn on 4/3/20

 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
 */
public class WordBreakII {
    public static void main(String[] args) {
        WordBreakII wordBreakII = new WordBreakII();

        System.out.println(
                Arrays.toString(
                        wordBreakII.wordBreak("catsanddog"
                                , Arrays.asList("cat", "cats", "and", "sand", "dog"))
                                .toArray()));
    }


    /*
    бежим по символам С - есть обьект
    index - текущий индекс
    startIdx - индекс первого символа
    value - значение из словаря

     */

    class Word {
        int currentIndex;
        int startIndex;
        String value;
        boolean isFull;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, Word> wordMap = new LinkedHashMap<>();
        List<String> rezList = new ArrayList<>();
        for (String wordFromDict : wordDict) {
            Word word = new Word();
            word.value = wordFromDict;
            wordMap.put(String.valueOf(wordFromDict.charAt(0)), word);
        }

        String[] chars = s.split("");

        for (int i = 0; i < chars.length; i++) {
            Word word = wordMap.get(chars[i]);
            if (word != null && !word.isFull) {
                int j = i;
                word.startIndex = i;
                word.currentIndex = j;
                String[] split = word.value.split("");
                for (int k = 0; k < split.length; k++) {
                    if (!chars[i + k].equals(split[k])) {
                        word.currentIndex = 0;
                        word.startIndex = 0;
                        break;
                    }
                }
                if (word.currentIndex - word.startIndex + 1 == word.value.length()) {
                    word.isFull = true;
                }
            }
        }

        return null;
    }
}
