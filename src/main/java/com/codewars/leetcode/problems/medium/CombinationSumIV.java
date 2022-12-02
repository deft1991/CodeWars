package com.codewars.leetcode.problems.medium;

/**
 * @author Sergey Golitsyn
 * created on 20.10.2022
 */
public class CombinationSumIV {

    public static void main(String[] args) {
        CombinationSumIV cs = new CombinationSumIV();
        System.out.println(cs.combinationSum4(new int[]{1,2,3}, 4)); // 7
    }

    /**
     * 0 0 0 0 0
     * 1 0 0 0 0
     *
     * i = 1
     * nums:
     * 1 --> dp[1] += dp[1-1] = 1
     * 2
     * 3
     *
     * 1 1 0 0 0
     * i = 2
     * nums:
     * 1 --> dp[2] += dp[2-1] = 1 (1)
     * 2 --> dp[2] += dp[2-2] = 1 (2)
     * 3
     *
     * 1 1 2 0 0
     * i = 3
     * nums:
     * 1 --> dp[3] += dp[3 - 1] = 2 (2)
     * 2 --> dp[3] += dp[3-2] = 1 (3)
     * 3 --> dp[3] += dp[3-3] = 1 (4)
     *
     * 1 1 2 4 0
     * nums:
     * 1 --> dp[4] += dp[4-1] = 4 (4)
     * 2 --> dp[4] += dp[4-2] = 2 (6)
     * 3 --> dp[4] += dp[4-3] = 1 (7)
     *
     * 1 1 2 4 7
     *
     * return 7
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;

        for (int i = 0; i <= target; i++){
            for (int num : nums){
                if (target - num <= i){
                    dp[i] += dp[target-num];
                }
            }
        }
        return dp[target];
    }

}
