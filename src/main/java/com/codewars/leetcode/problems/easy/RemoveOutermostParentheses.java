package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 23.02.2021
 */
public class RemoveOutermostParentheses {

    public static void main(String[] args) {
        RemoveOutermostParentheses ro = new RemoveOutermostParentheses();
        System.out.println(ro.removeOuterParentheses("(()())(())"));
        System.out.println(ro.removeOuterParentheses("()()"));
        System.out.println(ro.removeOuterParentheses("(()())(())(()(()))"));
    }

    public String removeOuterParentheses(String S) {
        char[] chars = S.toCharArray();
        StringBuilder result = new StringBuilder();

        int i = 0;
        int openCount = 0;

        while (i < chars.length){
            if ('(' == chars[i]){
                openCount ++;
            }
            if (openCount > 1){
                result.append(chars[i]);
            }
            if (')' == chars[i]){
                openCount --;
            }
            i ++;
        }
        return result.toString();
    }
}
