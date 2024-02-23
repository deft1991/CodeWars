package com.codewars.leetcode.daily;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 03.02.2024
 */
public class PartitionArrayMaximumSum {

    public static void main(String[] args) {
        PartitionArrayMaximumSum p = new PartitionArrayMaximumSum();
        System.out.println(p.maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3));
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);

        for(int start = n - 1; start >= 0; start--){
            int curMax = 0;
            int end = Math.min(n, start + k);

            for(int j = start; j < end; j++){
                curMax = Math.max(curMax, arr[j]);
                dp[start] = Math.max(dp[start], dp[j+1] + curMax * (j - start + 1));
            }
        }

        return dp[0];
    }
}
