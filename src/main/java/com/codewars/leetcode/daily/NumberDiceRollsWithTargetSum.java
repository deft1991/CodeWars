package com.codewars.leetcode.daily;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 26.12.2023
 */
public class NumberDiceRollsWithTargetSum {

    public static void main(String[] args) {
        NumberDiceRollsWithTargetSum n = new NumberDiceRollsWithTargetSum();
        System.out.println(n.numRollsToTarget(1,6,3)); // 1
        System.out.println(n.numRollsToTarget(2,6,7)); // 6
    }

    private int mod = (int) Math.pow(10, 9) + 7;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] mem = new int[n + 1][target + 1];
        for (int[] a : mem)
            Arrays.fill(a, -1);
        return backTrack(n, k, target, mem);
    }

    public int backTrack(int n, int k, int target, int[][] mem){
        if(n==0 && target == 0){
            return 1;
        }
        if(n <= 0 || target < 0){
            return 0;
        }
        if (mem[n][target] != -1)
            return mem[n][target];

        int count = 0;

        for(int i = 1; i <= k; i++){
            target -= i;
            count = (count + backTrack(n - 1, k, target, mem) % mod) % mod;
            target += i;
        }
        return mem[n][target] = count;
    }
}
