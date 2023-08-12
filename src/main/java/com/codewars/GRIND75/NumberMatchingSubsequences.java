package com.codewars.GRIND75;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 01.08.2023
 */
public class NumberMatchingSubsequences {

    public static void main(String[] args) {
        NumberMatchingSubsequences n = new NumberMatchingSubsequences();
        System.out.println(n.numMatchingSubseq("abcde", new String[]{"a","bb","acd","ace"})); // 3
        System.out.println(n.numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"})); // 2
    }

    public int numMatchingSubseq(String s, String[] words) {
        Map<String, Integer> dict = new HashMap<>();

        for (String word : words){
            dict.put(word, dict.getOrDefault(word, 0) + 1);
        }
        int rez = 0;
        for(String word : dict.keySet()){
            int readerS = 0;
            int readerB = 0;
            while (readerS < s.length() && readerB < word.length()){
                if(word.charAt(readerB) == s.charAt(readerS)){
                    readerS++;
                    readerB++;
                } else {
                    readerS++;
                }
            }
            if (readerB == word.length()){
                rez += dict.get(word);
            }
        }
        return rez;
    }
}
