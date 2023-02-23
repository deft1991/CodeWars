package com.codewars.neetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Sergey Golitsyn
 * created on 21.12.2022
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        System.out.println(Arrays.toString(dt.dailyTemperatures(new int[]{30, 60, 90}))); // 1 1 0
        System.out.println(Arrays.toString(dt.dailyTemperatures(new int[]{30,40,50,60}))); // 1 1 1 0
        System.out.println(Arrays.toString(dt.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}))); // 1 1 4 2 1 1 0 0
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] rez = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                rez[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        while (stack.isEmpty()) {
            rez[stack.pop()] = 0;
        }
        return rez;
    }
}
