package com.codewars.leetcode.daily;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 11.12.2023
 */
public class TransposeMatrix {

    public static void main(String[] args) {
        TransposeMatrix t = new TransposeMatrix();
        int[][] transpose = t.transpose(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        });
        for (int[] arr : transpose){
            System.out.println(Arrays.toString(arr));
        }
    }

    public int[][] transpose(int[][] matrix) {
        int[][]rez = new int[matrix[0].length][matrix.length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                rez[j][i] = matrix[i][j];
            }
        }
        return rez;
    }
}
