package com.codewars.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 12.08.2023
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();

        System.out.println(Arrays.toString(s.spiralOrder(new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        }).toArray()));
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        int left = 0;
        int right = matrix[0].length - 1;

        int top = 0;
        int bottom = matrix.length - 1;

        List<Integer> rez = new ArrayList<>();
        while (left <= right && top <= bottom) {

            // move right
            for (int i = left; i <= right; i++) {
                rez.add(matrix[top][i]);
            }
            top++;

            // move down
            for (int i = top; i <= bottom; i++) {
                rez.add(matrix[i][right]);
            }
            right--;

            // move left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    rez.add(matrix[bottom][i]);
                }
            }

            bottom--;
            // move up
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    rez.add(matrix[i][left]);
                }
            }
            left++;
        }
        return rez;
    }
}
