package com.codewars.leetcode.daily;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Sergey Golitsyn
 * created on 31.01.2024
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures d = new DailyTemperatures();
        System.out.println(Arrays.toString(d.dailyTemperatures(new int[]{30,40,50,60})));
        System.out.println(Arrays.toString(d.dailyTemperatures(new int[]{30,60,90})));
        System.out.println(Arrays.toString(d.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[]rez = new int[temperatures.length];

        stack.push(0);

        for(int i = 1; i < temperatures.length; i++){
            int cur = temperatures[i];

            while(!stack.isEmpty() && cur > temperatures[stack.peek()]){
                int prevIdx = stack.peek();
                rez[prevIdx] = i - prevIdx;
                stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            rez[stack.pop()] = 0;
        }
        return rez;
    }
}
