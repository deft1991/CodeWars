package com.codewars.leetcode.problems.medium;

import java.util.Stack;

/**
 * @author Sergey Golitsyn
 * created on 24.04.2021
 */
public class BasicCalculatorII {

    public static void main(String[] args) {
        BasicCalculatorII b = new BasicCalculatorII();
        System.out.println(b.calculate("3+2*2")); // 7
        System.out.println(b.calculate2("3+2*2")); // 7
        System.out.println(b.calculate("3/2")); // 1
        System.out.println(b.calculate2("3/2")); // 1
        System.out.println(b.calculate("3+5 / 2 ")); // 5
        System.out.println(b.calculate2("3+5 / 2 ")); // 5
        System.out.println(b.calculate("0-2147483647")); // -2147483647
        System.out.println(b.calculate2("0-2147483647")); // -2147483647
    }

    public int calculate(String s) {

        char[] chars = s.toCharArray();

        Stack<Integer> stack = new Stack<>();

        char operation = '+';
        int current = 0;
        for (int i = 0; i < chars.length; i++) {

            char c = chars[i];
            if (Character.isDigit(c)) {
                current = current * 10 + (c - '0');
            }

            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == chars.length - 1) {
                if ('-' == operation) {
                    stack.push(-current);
                } else if ('+' == operation) {
                    stack.push(current);
                } else if ('*' == operation) {
                    stack.push(stack.pop() * current);
                } else if ('/' == operation) {
                    stack.push(stack.pop() / current);
                }
                operation = c;
                current = 0;
            }
        }

        while (stack.size() > 1) {
            stack.push(stack.pop() + stack.pop());
        }

        return stack.pop();
    }

    public int calculate2(String s) {

        char[] chars = s.toCharArray();


        char operation = '+';

        int current = 0;
        int lastNumber = 0;
        int rez = 0;
        for (int i = 0; i < chars.length; i++) {

            char c = chars[i];
            if (Character.isDigit(c)) {
                current = current * 10 + (c - '0');
            }

            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == chars.length - 1) {
                if ('-' == operation || '+' == operation) {
                    rez += lastNumber;
                    lastNumber = '-' == operation ? -current : current;
                }  else if ('*' == operation) {
                    lastNumber *= current;
                } else if ('/' == operation) {
                    lastNumber /= current;
                }
                operation = c;
                current = 0;
            }
        }
        rez += lastNumber;
        return rez;
    }
}
