package com.codewars.leetcode.days14;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 22.02.2022
 */
public class Matrix01 {

    public static void main(String[] args) {
        Matrix01 m = new Matrix01();

//        System.out.println(Arrays.toString(m.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}})));
//        System.out.println(Arrays.toString(m.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}})));
        System.out.println(Arrays.toString(m.updateMatrix(new int[][]{
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {1, 0, 0, 0, 1}})));
    }

    public int[][] updateMatrix(int[][] mat) {
        int[][] rez = new int[mat.length][mat[0].length];

        if (mat[0][0] != 0) {
            rez[0][0] = 1;
        }

        for (int[] ints : rez) {
            Arrays.fill(ints, Integer.MAX_VALUE - 10000);
        }


        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    rez[i][j] = 0;
                } else {
                    if (i > 0) {
                        rez[i][j] = Math.min(rez[i][j], rez[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        rez[i][j] = Math.min(rez[i][j], rez[i][j - 1] + 1);
                    }
                }
            }
        }
        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                if (i < mat.length - 1) {
                    rez[i][j] = Math.min(rez[i][j], rez[i + 1][j] + 1);
                }
                if (j < mat[0].length - 1) {
                    rez[i][j] = Math.min(rez[i][j], rez[i][j + 1] + 1);
                }
            }
        }
        return rez;
    }
}
