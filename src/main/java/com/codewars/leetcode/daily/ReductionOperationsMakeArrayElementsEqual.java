package com.codewars.leetcode.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 19.11.2023
 */
public class ReductionOperationsMakeArrayElementsEqual {

    public static void main(String[] args) {
        ReductionOperationsMakeArrayElementsEqual r = new ReductionOperationsMakeArrayElementsEqual();
        System.out.println(r.reductionOperations(new int[]{5, 1, 3})); // 3
        System.out.println(r.reductionOperations(new int[]{1,1,1})); // 0
        System.out.println(r.reductionOperations(new int[]{1,1,2,2,3})); // 4
    }

    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);

        int rez = 0;
        int up = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i-1] != nums[i]){
                up++;
            }
            rez += up;
        }
        return rez;
    }
}
