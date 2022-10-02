package com.codewars.leetcode.problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 27.09.2022
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        List<String> strings1 = gp.generateParenthesis(1);
        System.out.println();
        List<String> strings2 = gp.generateParenthesis(3);
        System.out.println();
    }

    public List<String> generateParenthesis(int n) {

        List<String> rez = new ArrayList<>();
        StringBuilder cur = new StringBuilder();

        backtracking(0, 0, n, rez, cur);

        return rez;
    }

    private void backtracking(int openP, int closeP, int max, List<String> rez, StringBuilder cur) {
        if (cur.length() == max * 2) {
            rez.add(new String(cur));
        }

        if (openP < max) {
            cur.append("(");
            backtracking(openP + 1, closeP, max, rez, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (closeP < openP) {
            cur.append(")");
            backtracking(openP, closeP + 1, max, rez, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
