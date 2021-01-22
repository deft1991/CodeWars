package com.codewars.leetcode.topInterviewQuestions.easy.array;

/**
 * @author Sergey Golitsyn
 * created on 21.01.2021
 * <p>
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * <p>
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * <p>
 * Input: matrix = [[1,2],[3,4]]
 * Output: [[3,1],[4,2]]
 */
public class RotateImage {

    public static void main(String[] args) {
//        rotate(new int[][]{
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}});

        rotate(new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}});
    }

    public static void rotate(int[][] matrix) {

        for (int i = 0; i < matrix.length / 2; i++) {

            int bottom = matrix.length - 1; // length = 3, i = 0, bottom = 2, i = 1, bottom = 1

            for (int j = i; j < bottom - i; j++) {

                int tmp = matrix[i][j];

                matrix[i][j] = matrix[bottom - j][i];
                matrix[bottom - j][i] = matrix[bottom - i][bottom - j];
                matrix[bottom - i][bottom - j] = matrix[j][bottom - i];
                matrix[j][bottom - i] = tmp;
            }
        }
    }
}
