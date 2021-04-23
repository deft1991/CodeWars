package com.codewars.leetcode.problems.hard;

/**
 * @author Sergey Golitsyn
 * created on 20.04.2021
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {

    }

    public int largestRectangleArea(int[] heights) {

        if (heights.length < 2){
            return heights[0];
        }

        int start = heights[0];
        int max = 0;
        for (int i = 1; i < heights.length; i++) {
            int cur = heights[i];

        }

        return 0;
    }
}
