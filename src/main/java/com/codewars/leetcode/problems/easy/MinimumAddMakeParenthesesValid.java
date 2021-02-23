package com.codewars.leetcode.problems.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Sergey Golitsyn
 * created on 23.02.2021
 *
 * Given a string S of '(' and ')' parentheses,
 * we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
 *
 *
 *
 * Example 1:
 *
 * Input: "())"
 * Output: 1
 * Example 2:
 *
 * Input: "((("
 * Output: 3
 * Example 3:
 *
 * Input: "()"
 * Output: 0
 * Example 4:
 *
 * Input: "()))(("
 * Output: 4
 */
public class MinimumAddMakeParenthesesValid {

    public static void main(String[] args) {
        MinimumAddMakeParenthesesValid m = new MinimumAddMakeParenthesesValid();

        System.out.println(m.minAddToMakeValid("())"));
        System.out.println(m.minAddToMakeValid("((("));
        System.out.println(m.minAddToMakeValid("()"));
        System.out.println(m.minAddToMakeValid("()))(("));
    }

    public int minAddToMakeValid(String S) {
        Deque<Character> deque = new ArrayDeque<>();
        int count = 0;
        for (Character c : S.toCharArray()) {
            if ('(' == c){
                deque.push(c);
            } else {
               if (deque.isEmpty()){
                   count ++;
               } else {
                   deque.pop();
               }
            }
        }
        return count + deque.size();
    }
}
