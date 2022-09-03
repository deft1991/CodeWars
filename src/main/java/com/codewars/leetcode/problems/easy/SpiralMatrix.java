package com.codewars.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 02.09.2022
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        List<Integer> integers = spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(integers); // 1 2 3 6 9 8 7 4 5
        List<Integer> integers3 = spiralOrder(new int[][]{{1, 2}, {3, 4}});
        System.out.println(integers3); // 1 2 4 3
        List<Integer> integers2 = spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}); // 1,2,3,4,8,12,11,10,9,5,6,7
        System.out.println(integers2);
        List<Integer> integers4 = spiralOrder(new int[][]{{7}, {9}, {6}}); // 7,9,6
        System.out.println(integers4);

        List<Integer> integers5 = spiralOrder(new int[][]{{1,2,3}, {4,5,6}}); // 1,2,3,6,5,4
        System.out.println(integers5);

        List<Integer> integers6 = spiralOrder(new int[][]{{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}}); // 1,2,3,6,5,4
        System.out.println(integers6);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        List<Integer> rez = new ArrayList<>();

        while (top <= bottom && left <= right) {
            //move right
            for (int i = left; i <= right; i++) {
                rez.add(matrix[top][i]);
            }

            // go to next line
            top++;
            //Move down
            for (int i = top; i <= bottom; i++) {
                rez.add(matrix[i][right]);
            }
            //Move column pointer to left
            right--;

            //Move left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    rez.add(matrix[bottom][i]);
                }
            }
            bottom--;

            //move up
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
