package com.codewars.leetcode.problems.medium;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 03.09.2022
 */
public class RotateImage {

    public static void main(String[] args) {
//        int[][] ints = {{1, 2}, {3, 4}};
//        rotate(ints);
//        System.out.println(Arrays.toString(ints));
//
//        int[][] ints2 = {{1, 2, 3}, {4, 5, 6}, {7,8,9}};
//        rotate(ints2);
//        System.out.println(Arrays.toString(ints2));

        int[][] ints3 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(ints3);
        // [[15,13,2,5],
        // [14,3,4,1],
        // [12,6,8,9],
        // [16,7,10,11]]
        System.out.println(Arrays.toString(ints3));
    }

    public static void rotate(int[][] matrix) {

        int n = matrix.length-1;

        for(int row = 0; row < (n+1)/2; row ++){
            for(int column = row; column < n - row; column ++){
                // swap left top with left bottom
                swap(matrix, row, column, n - column, row);
                // swap left with right
                swap(matrix, n - column, row, n - row, n - column);
                // swap bottom right with top right
                swap(matrix, n - row, n - column, column, n - row);
            }
        }

    }

    public static void swap(int[][] matrix, int rowFrom, int colFrom, int rowTo, int colTo){
        int tmp = matrix[rowFrom][colFrom];
        matrix[rowFrom][colFrom] = matrix[rowTo][colTo];
        matrix[rowTo][colTo] = tmp;
    }
}
