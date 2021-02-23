package com.codewars.leetcode.problems.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Sergey Golitsyn
 * created on 21.02.2021
 */
public class BaseballGame {

    public static void main(String[] args) {
        BaseballGame bg = new BaseballGame();
//        System.out.println(bg.calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(bg.calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
//        System.out.println(bg.calPoints(new String[]{"1"}));
    }

    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>(ops.length);

        for (String op : ops) {
            if ("+".equals(op)){
                Integer first = stack.pop();
                Integer second = stack.pop();
                Integer third = first + second;
                stack.push(second);
                stack.push(first);
                stack.push(third);
            } else if ("D".equals(op)){
                Integer peek = stack.peek();
                stack.push(peek * 2);
            } else if ("C".equals(op)){
                stack.pop();
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        return stack.stream().mapToInt(Integer::intValue).sum();
    }

}
