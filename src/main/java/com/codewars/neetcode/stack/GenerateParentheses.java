package com.codewars.neetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Sergey Golitsyn
 * created on 20.12.2022
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
//        List<String> strings = g.generateParenthesis(1);
//        System.out.println();
//        List<String> strings1 = g.generateParenthesis(2);
//        System.out.println();
        List<String> strings2 = g.generateParenthesis(3);
        System.out.println();
    }

    public List<String> generateParenthesis(int n) {
       List<String> rez = new ArrayList<>();
       StringBuilder sb = new StringBuilder();

       backtrack(0,0, n, sb, rez);
       return rez;
    }

    private void backtrack(int open, int close, int n, StringBuilder sb, List<String> rez) {
        if (open == close && close == n){
            rez.add(sb.toString());
        }
        if (open < n){
            sb.append("(");
            backtrack(open + 1, close, n, sb, rez);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open){
            sb.append(")");
            backtrack(open, close + 1, n, sb, rez);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
