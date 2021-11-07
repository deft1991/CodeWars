package com.codewars.trainingSkills;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Sergey Golitsyn
 * created on 11.05.2021
 */
public class DigitalTree {

    public static void main(String[] args) {
        DigitalTree d = new DigitalTree();
        System.out.println(d.longestChristmasGarland(new int[][]{
                {1, 0, 0, 0},
                {2, 3, 0, 0},
                {4, 5, 6, 0},
                {9, 8, 0, 3}
        }));

    }

    public int longestChristmasGarland(int[][] arr) {
        // i = arr.length - 2 because we get line under last line
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] += Math.max(arr[i + 1][j], arr[i + 1][j + 1]);
            }
        }
        return arr[0][0];
    }

}
