package com.codewars.neetcode.stack;

import java.util.Stack;

/**
 * @author Sergey Golitsyn
 * created on 19.12.2022
 */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid("()")); // true
        System.out.println(v.isValid("()[]{}"));// true
        System.out.println(v.isValid("(]")); // false
        System.out.println(v.isValid("(((")); // false
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '{' || cur == '[') {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if ((cur == ')' && stack.peek() != '(') ||
                        (cur == '}' && stack.peek() != '{') ||
                        (cur == ']' && stack.peek() != '[')
                ) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
