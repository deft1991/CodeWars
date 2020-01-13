package com.codewars.leetcode.array;

/*
 * Created by sgolitsyn on 11/21/19
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();

        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(new int[]{1,1,2}));
    }

    public int removeDuplicates(int[] nums) {
        if(nums != null && nums.length > 0){
            int len = 0;
            int prev = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (prev != nums[i]){
                    len ++;
                    nums[len] = nums[i];
                    prev = nums[i];
                }
            }
            return len + 1;
        }
        return 0;
    }
}
