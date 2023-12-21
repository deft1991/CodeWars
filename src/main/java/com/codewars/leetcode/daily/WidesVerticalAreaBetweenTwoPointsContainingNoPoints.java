package com.codewars.leetcode.daily;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 21.12.2023
 */
public class WidesVerticalAreaBetweenTwoPointsContainingNoPoints {

    public static void main(String[] args) {

    }

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int max = 0;

        for(int i = 1; i < points.length; i++){
            if(points[i][0] - points[i-1][0] > max)
                max = points[i][0] - points[i-1][0];
        }
        return max;
    }
}
