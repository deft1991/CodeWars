package com.codewars.leetcode.days21;

/**
 * @author Sergey Golitsyn
 * created on 16.03.2022
 */
public class SubarrayProductLessThanK {

    public static void main(String[] args) {
        SubarrayProductLessThanK s = new SubarrayProductLessThanK();
        System.out.println(s.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100)); // 8
//        System.out.println(s.numSubarrayProductLessThanK(new int[]{1,2,3}, 0)); //
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int rez = 0;
        int start = 0;
        int count = 1;
        int end = 0;
        for (end = 0; end < nums.length; end ++) {
            count *= nums[end];

            while (count >= k){
                count /= nums[start];
                start++;
            }
            rez += end - start + 1;
        }
        return rez;
    }
}
