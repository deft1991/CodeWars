package com.codewars.faangtalk;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 13.09.2023
 */
public class ProductArrayExceptSelf {

    public static void main(String[] args) {
        ProductArrayExceptSelf p = new ProductArrayExceptSelf();
        System.out.println(Arrays.toString(p.productExceptSelf(new int[]{1,2,3,4})));
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] rez = new int[n];

        rez[0] = 1;

        for(int i = 1; i < n; i++){
            rez[i] = nums[i-1] * rez[i-1];
        }

        int prev = 1;

        for(int i = n - 2; i >= 0; i--){
            prev = prev * nums[i+1];
            rez[i]*= prev;
        }

        return rez;
    }
}
