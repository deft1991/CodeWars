package com.codewars.neetcode.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 03.07.2023
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: ["()"]
 */
public class GenerateParentheses2 {

    public static void main(String[] args) {
        GenerateParentheses2 g = new GenerateParentheses2();
        List<String> strings = g.generateParenthesis(3);
        System.out.println(Arrays.toString(strings.toArray()));
    }

    public List<String> generateParenthesis(int n) {
        StringBuilder cur = new StringBuilder();
        List<String> rez = new ArrayList<>();

        backtracking(0, 0, n, cur, rez);
        return rez;
    }

    private void backtracking(int open, int close, int n, StringBuilder cur, List<String> rez) {
        if (open == close && n == open) {
            rez.add(cur.toString());
        } else {
            if (open < n) {
                cur.append("(");
                backtracking(open + 1, close, n, cur, rez);
                cur.deleteCharAt(cur.length() - 1);
            }
            if (open > close) {
                cur.append(")");
                backtracking(open, close + 1, n, cur, rez);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
}
