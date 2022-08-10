package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 02.08.2022
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1,1,2}));
    }

    public static int removeDuplicates(int[] nums) {

        // todo position to read
        // todo position to write
        // if read != write --> write on ++write position
        // reader ++

        int reader = 1;
        int writer = 0;

        while (reader < nums.length){
            if (nums[writer] != nums[reader]){
                nums[++writer] = nums[reader];
            }
            reader++;
        }
        return writer + 1;
    }
}
