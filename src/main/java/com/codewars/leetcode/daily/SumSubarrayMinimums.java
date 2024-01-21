package com.codewars.leetcode.daily;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Sergey Golitsyn
 * created on 20.01.2024
 */
public class SumSubarrayMinimums {

    public static void main(String[] args) {
        SumSubarrayMinimums s = new SumSubarrayMinimums();
        System.out.println(s.sumSubarrayMins(new int[]{4, 3, 2, 1}));
    }

    public int sumSubarrayMins(int[] arr) {
        int length = arr.length;
        int[] left = new int[length];
        int[] right = new int[length];

        Arrays.fill(left, -1);
        Arrays.fill(right, length);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < length; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        int mod = (int) 1e9 + 7;
        long answer = 0;

        for (int i = 0; i < length; ++i) {
            answer += (long) (i - left[i]) * (right[i] - i) % mod * arr[i] % mod;
            answer %= mod;
        }

        return (int) answer;
    }
}
