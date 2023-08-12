package com.codewars.GRIND75;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 01.08.2023
 */
public class Matrix01 {

    public static void main(String[] args) {
        Matrix01 m = new Matrix01();
        int[][] ints = m.updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        });
        for (int[] arr : ints) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] tmp = new int[n][m];

        for (int[] arr : tmp) {
            Arrays.fill(arr, Integer.MAX_VALUE - 10000);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    tmp[i][j] = 0;
                } else {

                    if (i - 1 >= 0) {
                        tmp[i][j] = Math.min(tmp[i][j], tmp[i - 1][j] + 1);
                    }
                    if (j - 1 >= 0) {
                        tmp[i][j] = Math.min(tmp[i][j], tmp[i][j - 1] + 1);
                    }
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    tmp[i][j] = 0;
                } else {
                    if (i + 1 < n) {
                        tmp[i][j] = Math.min(tmp[i][j], tmp[i + 1][j] + 1);
                    }
                    if (j + 1 < m) {
                        tmp[i][j] = Math.min(tmp[i][j], tmp[i][j + 1] + 1);
                    }
                }
            }
        }

        return tmp;
    }
}
