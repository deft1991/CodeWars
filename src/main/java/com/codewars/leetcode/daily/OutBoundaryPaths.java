package com.codewars.leetcode.daily;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 26.01.2024
 */
public class OutBoundaryPaths {

    public static void main(String[] args) {
        OutBoundaryPaths o = new OutBoundaryPaths();
        System.out.println(o.findPaths(2, 2, 2, 0, 0));
    }

    int mod = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] memo = new int[m][n][maxMove + 1];

        for (int[][] arr : memo) {
            for (int[] arr2 : arr) {
                Arrays.fill(arr2, -1);
            }
        }

        return dfs(m, n, maxMove, startRow, startColumn, memo);
    }

    private int dfs(int m, int n, int maxMove, int startRow, int startColumn, int[][][] memo) {
        if (startRow == m || startColumn == n || startRow < 0 || startColumn < 0) {
            return 1;
        }
        if (maxMove == 0) {
            return 0;
        }
        if (memo[startRow][startColumn][maxMove] >= 0) {
            return memo[startRow][startColumn][maxMove];
        }

        memo[startRow][startColumn][maxMove] = dfs(m, n, maxMove - 1, startRow - 1, startColumn, memo) % mod +
                dfs(m, n, maxMove - 1, startRow + 1, startColumn, memo) % mod +
                dfs(m, n, maxMove - 1, startRow, startColumn - 1, memo) % mod +
                dfs(m, n, maxMove - 1, startRow, startColumn + 1, memo) % mod;
        return memo[startRow][startColumn][maxMove];
    }
}
