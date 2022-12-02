package com.codewars.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 02.10.2022
 */
public class LetterCombinationsPhoneNumber {

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber lc = new LetterCombinationsPhoneNumber();

//        List<String> strings1 = lc.letterCombinations("23");
//        System.out.println(strings1);
        List<String> strings2 = lc.letterCombinations("24");
        System.out.println(strings2);
        List<String> strings3 = lc.letterCombinations("42");
        System.out.println(strings3);
        List<String> strings4 = lc.letterCombinations("234");
        System.out.println(strings4);
        List<String> strings5 = lc.letterCombinations("");
        System.out.println(strings5);
        List<String> strings6 = lc.letterCombinations("2");
        System.out.println(strings6);
    }



    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()){
            return null;
        }
        Map<Character, String> dict = new HashMap<>();
        dict.put('2', "abc");
        dict.put('3', "def");
        dict.put('4', "ghi");
        dict.put('5', "jkl");
        dict.put('6', "mno");
        dict.put('7', "pqrs");
        dict.put('8', "tuv");
        dict.put('9', "wxyz");
        List<String> rez = new ArrayList<>();
        StringBuilder cur = new StringBuilder();

        backtrack(digits, dict, 0, rez, cur);

        return rez;
    }

    private void backtrack(String digits, Map<Character, String> dict, int start, List<String> rez, StringBuilder cur) {
        if (start == digits.length()){
            rez.add(cur.toString());
        } else {
            String word = dict.get(digits.charAt(start));
            for (int i = 0; i < word.length(); i++){
                cur.append(word.charAt(i));
                backtrack(digits, dict, start + 1, rez, cur);
                cur.deleteCharAt(cur.length()-1);
            }
        }
    }
}
