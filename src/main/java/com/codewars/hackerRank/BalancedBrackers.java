package com.codewars.hackerRank;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
 * Created by sgolitsyn on 1/16/20
 */
public class BalancedBrackers {

    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("{[(])}"));
        System.out.println(isBalanced("{{[[(())]]}}"));
    }

    // (, ), {, }, [, or ].


    // 2
    // i = 1 prev = 1 cur = 1* 1
    // i = 2 prev = 1 cur = 2 * 1
    // i = 3 prev = 2 cur = 3 * 2;
    // i = 4 prev = 6 cur = 4 * 6
    static String isBalanced(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (stack.isEmpty()){
                    return "NO";
                }
                Character pop = stack.pop();
                if (c == ')' && pop != '(') {
                    return "NO";
                } else if (c == '}' && pop != '{') {
                    return "NO";
                } else if (c == ']' && pop != '[') {
                    return "NO";
                }
            }
        }
        if (!stack.isEmpty()){
            return "NO";
        }

        return "YES";
    }


}
