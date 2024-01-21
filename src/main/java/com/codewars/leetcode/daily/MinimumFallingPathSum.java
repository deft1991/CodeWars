package com.codewars.leetcode.daily;

/**
 * @author Sergey Golitsyn
 * created on 19.01.2024
 */
public class MinimumFallingPathSum {

    public static void main(String[] args) {
        MinimumFallingPathSum m = new MinimumFallingPathSum();
        System.out.println(m.minFallingPathSum(new int[][]{
                {2,1,3},
                {6,5,4},
                {7,8,9},
        }));
    }

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int[][]dp = new int[n][m];

        for(int i = 0; i < matrix[0].length; i++){
            dp[0][i] = matrix[0][i];
        }
        for(int i = 1; i < matrix[0].length; i++){
            for(int j = 0; j < matrix[0].length; j++)
                dp[i][j] = Integer.MAX_VALUE;
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                int cur = matrix[i][j];
                if(j-1 >= 0){
                    dp[i][j] = Math.min(dp[i][j], cur + dp[i-1][j-1]);
                }
                dp[i][j] = Math.min(dp[i][j], cur + dp[i-1][j]);
                if(j+1 < matrix.length){
                    dp[i][j] = Math.min(dp[i][j], cur + dp[i-1][j+1]);
                }
            }
        }
        int rez = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++){
            rez = Math.min(rez, dp[m - 1][j]);
        }
        return rez;
    }
}
