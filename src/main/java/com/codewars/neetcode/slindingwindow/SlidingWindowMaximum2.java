package com.codewars.neetcode.slindingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 25.07.2023
 */
public class SlidingWindowMaximum2 {

    public static void main(String[] args) {
        SlidingWindowMaximum2 s = new SlidingWindowMaximum2();
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int start = 0;
        int end = 0;
        int[] rez = new int[nums.length - k + 1];

        while (end < nums.length) {
            // remove small values
            while(!deque.isEmpty() && nums[end] > nums[deque.peekFirst()]){
                deque.pollLast();
            }

            deque.offer(end);

            if(!deque.isEmpty() && deque.peekFirst() < start){
                deque.pollFirst();
            }

            if (end + 1 >= k){
                rez[start] = nums[deque.peekFirst()];
                start++;
            }

            end++;
        }
        return rez;
    }
}
