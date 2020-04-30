package com.codewars.leetcode.problems.easy;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Created by sgolitsyn on 4/9/20
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("()")); //true
        System.out.println(validParentheses.isValid("()[]{}")); //true
        System.out.println(validParentheses.isValid("(]")); // false
        System.out.println(validParentheses.isValid("([)]")); // false
        System.out.println(validParentheses.isValid("{[]}")); //true
    }

    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        char[] chars = s.toCharArray();

        Deque<Character> stack = new LinkedList<Character>();

        for (Character c : chars) {
            if ('(' == c || '[' == c || '{' == c) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character poll = stack.poll();
                if ((')' == c && poll != '(')
                        || (']' == c && poll != '[')
                        || ('}' == c && poll != '{')) {
                    return false;

                }
            }
        }
        return stack.isEmpty();
    }
}
