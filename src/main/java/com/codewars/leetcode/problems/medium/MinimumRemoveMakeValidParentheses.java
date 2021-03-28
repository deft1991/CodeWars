package com.codewars.leetcode.problems.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Sergey Golitsyn
 * created on 19.03.2021
 */
public class MinimumRemoveMakeValidParentheses {

    public static void main(String[] args) {
        MinimumRemoveMakeValidParentheses m = new MinimumRemoveMakeValidParentheses();
//        System.out.println(m.minRemoveToMakeValid("lee(t(c)o)de)"));
//        System.out.println(m.minRemoveToMakeValid("a)b(c)d"));
//        System.out.println(m.minRemoveToMakeValid("))(("));
//        System.out.println(m.minRemoveToMakeValid("(a(b(c)d)"));
        System.out.println(m.minRemoveToMakeValid("())()((("));
    }

    public String minRemoveToMakeValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char aChar : chars) {
            if ('(' == aChar) {
                deque.push('(');
                sb.append('(');
            } else if (')' == aChar && !deque.isEmpty()) {
                deque.pop();
                sb.append(')');
            } else if (')' == aChar) {
                // do nothing
            } else {
                sb.append(aChar);
            }
        }

        while(!deque.isEmpty()){
            sb.deleteCharAt(sb.lastIndexOf("("));
            deque.pop();
        }
        return sb.toString();
    }
}
