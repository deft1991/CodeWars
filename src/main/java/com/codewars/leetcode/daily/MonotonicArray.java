package com.codewars.leetcode.daily;

/**
 * @author Sergey Golitsyn
 * created on 05.02.2024
 */
public class MonotonicArray {

    public static void main(String[] args) {
        MonotonicArray m = new MonotonicArray();
        System.out.println(m.isMonotonic(new int[] {1,2,2,3}));
        System.out.println(m.isMonotonic(new int[] {6,5,4,4}));
        System.out.println(m.isMonotonic(new int[] {1,3,2}));
    }

    public boolean isMonotonic(int[] nums) {
        int direction = 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] < nums[i] && direction == -1){
                return false;
            }
            if(nums[i-1] > nums[i] && direction == 1){
                return false;
            }
            if(nums[i-1] < nums[i]){
                direction = 1;
            } else if (nums[i-1] > nums[i]){
                direction = -1;
            }

        }
        return true;
    }
}
