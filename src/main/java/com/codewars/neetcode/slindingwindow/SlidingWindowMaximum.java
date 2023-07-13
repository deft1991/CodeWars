package com.codewars.neetcode.slindingwindow;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 16.12.2022
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1, 2, 3}, 2))); // 2, 3
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1, 2, 3, 1, 1, 4, 1, 2}, 2))); // 2, 3, 3, 1, 4, 4, 2
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3))); // 3,3,5,5,6,7
    }



    public int[] maxSlidingWindow2(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && q.peekFirst() < i - k + 1){
                q.pollFirst();
            }
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) ans[j++] = nums[q.peekFirst()];
        }
        return ans;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] rez = new int[nums.length - k + 1];
        int i = 0;

        for (int right = 0; right < nums.length; right++) {
            while(!dq.isEmpty() && dq.peekFirst() < right - k + 1){
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[right]){
                dq.pollLast();
            }

            dq.offer(right);
            if (!dq.isEmpty() && right >= k - 1) {
                rez[i++] = nums[dq.peekFirst()];
            }
        }
        return rez;
    }
}
