package com.codewars.leetcode.dataStructure;

import java.util.Stack;

/**
 * @author Sergey Golitsyn
 * created on 19.04.2022
 */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();

        System.out.println(v.isValid("(]"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            char cur = chars[i];

            if('(' == cur || '{' == cur || '[' == cur){
                stack.push(cur);
            } else {
                if (stack.isEmpty()){
                    return false;
                } else if(
                        (')' == cur && '(' ==  stack.peek())
                                || ('}' == cur && '{' ==  stack.peek())
                                || (']' == cur && '[' ==  stack.peek())
                ){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
