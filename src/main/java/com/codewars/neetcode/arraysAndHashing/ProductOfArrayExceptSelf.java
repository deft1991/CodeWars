package com.codewars.neetcode.arraysAndHashing;

/**
 * @author Sergey Golitsyn
 * created on 04.12.2022
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] toRight = new int[n];
        int[] toLeft = new int[n];

        toRight[0] = 1;
        toLeft[n-1] = 1;
        for(int i = 1; i < n; i++){
            toRight[i] = nums[i-1] * toRight[i-1];
        }
        for(int i = n-2; i >=0; i--){
            toLeft[i] = nums[i+1] * toLeft[i+1];
        }
        for(int i = 0; i < n; i ++){
            toRight[i] *= toLeft[i];
        }
        return toRight;
    }
}
