package com.codewars.facebook;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 06.09.2023
 */
public class LetterCombinationsPhoneNumber {

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber l = new LetterCombinationsPhoneNumber();
        List<String> strings = l.letterCombinations("23");
        System.out.println(Arrays.toString(strings.toArray()));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()){
            return new ArrayList<>();
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
        if(cur.length() == digits.length()){
            rez.add(cur.toString());
            return;
        }
        String chars = dict.get(digits.charAt(start));
        if(chars == null){
            return;
        }
        for(int i = 0; i < chars.length(); i ++){
            cur.append(chars.charAt(i));
            backtrack(digits, dict, start + 1, rez, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}
