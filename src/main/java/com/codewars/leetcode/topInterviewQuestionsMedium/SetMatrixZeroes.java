package com.codewars.leetcode.topInterviewQuestionsMedium;

import java.util.Arrays;

/*
 * Created by sgolitsyn on 8/13/20
 *
Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 Do it in-place.
 Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
*
* Input:
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output:
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();

        int[][] arr1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};

        int[][] arr2 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};

        int[][] arr3 = {
                {1, 0}
        };

//        setMatrixZeroes.setZeroes(arr1);
        setMatrixZeroes.setZeroes(arr3);
        System.out.println(Arrays.toString(arr2));
    }

    public void setZeroes(int[][] matrix) {
        boolean containsZeroInLine = false;
        boolean containsZeroInRow = false;

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                containsZeroInLine = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                containsZeroInRow = true;
                break;
            }
        }


        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // lines
        for (int i = 1; i < matrix.length; i++) {
            int val = matrix[i][0];

            if (val == 0) {
                fillLine(matrix, i);
            }
        }

        // columns
        for (int i = 1; i < matrix[0].length; i++) {
            int val = matrix[0][i];

            if (val == 0) {
                fillRow(matrix, i);
            }
        }

        if (containsZeroInLine){
            Arrays.fill(matrix[0], 0);
        }

        if (containsZeroInRow){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    private void fillLine(int[][] matrix, int lineIdx) {

        for (int i = 1; i < matrix[lineIdx].length; i++) {
            matrix[lineIdx][i] = 0;
        }
    }

    private void fillRow(int[][] matrix, int rowIdx) {
        for (int i = 1; i < matrix.length; i++) {
            matrix[i][rowIdx] = 0;
        }
    }
}
