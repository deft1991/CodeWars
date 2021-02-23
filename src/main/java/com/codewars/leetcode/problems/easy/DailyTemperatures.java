package com.codewars.leetcode.problems.easy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Sergey Golitsyn
 * created on 23.02.2021
 * <p>
 * Given a list of daily temperatures T,
 * return a list such that, for each day in the input,
 * tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
 * <p>
 * For example,
 * given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73],
 * your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * <p>
 * Note: The length of temperatures will be in the range [1, 30000].
 * Each temperature will be an integer in the range [30, 100].
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();

        System.out.println(Arrays.toString(dt.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> deque = new ArrayDeque<>(T.length);
        int[] rez = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            int current = T[i];
            while (!deque.isEmpty() && T[deque.peek()] < current) {
                deque.pop();
            }

            rez[i] = deque.isEmpty() ? 0 : deque.peek() - i;
            deque.push(i);
        }
        return rez;
    }
}
