package com.codewars.leetcode.daily;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 18.03.2024
 */
public class MinimumNumberArrowsBurstBalloons {

    public static void main(String[] args) {
        MinimumNumberArrowsBurstBalloons m = new MinimumNumberArrowsBurstBalloons();
        System.out.println(m.findMinArrowShots(new int[][]{
                {10, 16},
                {2, 8},
                {1, 6},
                {7, 12},
        }));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int rez = 1;
        int cur = 0;

        for (int i = 1; i < points.length; i++) {
            if (points[cur][1] < points[i][0]) {
                rez++;
                cur = i;
            }
        }
        return rez;
    }
}
