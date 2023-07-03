package com.codewars.neetcode.stack;

import java.util.Stack;

/**
 * @author Sergey Golitsyn
 * created on 03.07.2023
 * <p>
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * <p>
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 */
public class EvaluateReversePolishNotation2 {

    public static void main(String[] args) {
        EvaluateReversePolishNotation2 e = new EvaluateReversePolishNotation2();
        System.out.println(e.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(e.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "*":
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a * b);
                    break;
                case "/":
                    int c = stack.pop();
                    int d = stack.pop();
                    stack.push(d / c);
                    break;
                case "+":
                    int e = stack.pop();
                    int f = stack.pop();
                    stack.push(e + f);
                    break;
                case "-":
                    int g = stack.pop();
                    int h = stack.pop();
                    stack.push(h - g);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
