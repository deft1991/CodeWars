package com.codewars.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 11.09.2022
 * <p>
 * Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
 * <p>
 * Return a list of all possible strings we could create. Return the output in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "a1b2"
 * Output: ["a1b2","a1B2","A1b2","A1B2"]
 * Example 2:
 * <p>
 * Input: s = "3z4"
 * Output: ["3z4","3Z4"]
 */
public class LetterCasePermutation {

    public static void main(String[] args) {
        LetterCasePermutation lcp = new LetterCasePermutation();
        lcp.letterCasePermutation("ab");
        List<String> a1b2 = lcp.letterCasePermutation("a1b2");
        List<String> strings = lcp.letterCasePermutation("3z4");
        System.out.println();
    }

    public List<String> letterCasePermutation(String s) {
        List<String> rez = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        backtrack(s, 0, rez, cur);
        return rez;
    }

    private void backtrack(String word, int idx, List<String> rez, StringBuilder cur) {
        // add word to rez
        if (idx >= word.length()) {
            rez.add(cur.toString());
            return;
        }

        // add lower char
        char curChar = word.charAt(idx);
        char lower = Character.toLowerCase(curChar);
        cur.append(lower);
        // backtrack
        backtrack(word, idx + 1, rez, cur);
        // remove char
        cur.deleteCharAt(cur.length() - 1);

        // check that not a digit
        if (!Character.isDigit(curChar)) {
            // add upper char
            char upper = Character.toUpperCase(curChar);
            cur.append(upper);
            // backtrack
            backtrack(word, idx + 1, rez, cur);
            // remove char
            cur.deleteCharAt(cur.length() - 1);
        }
    }


}
