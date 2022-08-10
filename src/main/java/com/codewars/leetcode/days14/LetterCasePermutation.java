package com.codewars.leetcode.days14;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 25.02.2022
 */
public class LetterCasePermutation {

    public static void main(String[] args) {
        LetterCasePermutation l = new LetterCasePermutation();
        l.letterCasePermutation("a1b2");
    }

    List<String> rez;
    StringBuilder cur;
    int[] charIdx;

    public List<String> letterCasePermutation(String s) {
        rez = new ArrayList<>();
        cur = new StringBuilder();
        charIdx = new int[s.length()];

        char[] chars = s.toCharArray();
        backtraking(0, chars, s.length());
        return rez;
    }


    private void backtraking(int i, char[] chars, int k) {
        if (k == 0 ) {
            rez.add(cur.toString());
            return;
        }


        if (charIdx[i] != 1) {
            charIdx[i]++;
            char lower = Character.toLowerCase(chars[i]);
            cur.append(lower);
            backtraking(i + 1, chars, k - 1);
            cur.deleteCharAt(cur.length() - 1);
            charIdx[i]--;

            if (!Character.isDigit(chars[i])) {
                charIdx[i]++;
                char upper = Character.toUpperCase(chars[i]);
                cur.append(upper);
                backtraking(i + 1, chars, k - 1);
                cur.deleteCharAt(cur.length() - 1);
                charIdx[i]--;
            }
        }
    }
}
