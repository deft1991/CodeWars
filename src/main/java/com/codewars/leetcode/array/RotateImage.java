package com.codewars.leetcode.array;

import java.util.Arrays;

/*
 * Created by sgolitsyn on 1/12/20
 *

 You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */
public class RotateImage {

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotateImage.rotate(matrix);
        System.out.println(Arrays.toString(matrix));

        matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotateImage.rotate(matrix);
        System.out.println(Arrays.toString(matrix));
    }

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            int layout = i;
            int qqq = i + 1;
            for (int j = 0; j < matrix[i].length - layout - qqq ; j++) {
                int tmp = matrix[layout][layout + j];
                int length = matrix[i].length - 1;
                int delim = length - j - layout;
                matrix[layout][layout + j] = matrix[delim][layout];
                matrix[delim][layout] = matrix[length - layout][delim];
                matrix[length - layout][delim] = matrix[layout + j][length - layout];
                matrix[layout + j][length - layout] = tmp;
            }
        }
    }
}
