package com.codewars.neetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Sergey Golitsyn
 * created on 06.07.2023
 *
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i]
 * is the number of days you have to wait after
 * the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 */
public class DailyTemperatures2 {

    public static void main(String[] args) {
        DailyTemperatures2 d = new DailyTemperatures2();
        System.out.println(Arrays.toString(d.dailyTemperatures(new int[]{1,2,3,2,4}))); // [1,1,2,1,0]
        System.out.println(Arrays.toString(d.dailyTemperatures(new int[]{30,60,90}))); // [1,1,0]
        System.out.println(Arrays.toString(d.dailyTemperatures(new int[]{30,40,50,60}))); // [1,1,1,0]
        System.out.println(Arrays.toString(d.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}))); // [1,1,4,2,1,1,0,0]
    }

    /**
     [1,3,4,2,3]
     [1,1,0,1,0]




     */
    public int[] dailyTemperatures(int[] temperatures) {

        int[] rez = new int[temperatures.length];
        rez[temperatures.length - 1] = 0;

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                rez[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        return rez;
    }
}
