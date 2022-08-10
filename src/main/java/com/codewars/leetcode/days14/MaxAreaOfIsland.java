package com.codewars.leetcode.days14;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 22.02.2022
 */
public class MaxAreaOfIsland {

    public static void main(String[] args) {
        MaxAreaOfIsland m = new MaxAreaOfIsland();
        System.out.println(m.maxAreaOfIsland(new int[][]{{1, 1, 1}, {0, 1, 0}, {1, 1, 1}})); // 7
        System.out.println(m.maxAreaOfIsland(new int[][]{{1, 1, 1}, {0, 0, 0}, {1, 1, 1}})); // 3
        System.out.println(m.maxAreaOfIsland(new int[][]{{1, 1, 1}, {0, 0, 0}, {0, 1, 1}})); // 3
        System.out.println(m.maxAreaOfIsland(new int[][]{{1, 1, 0}, {0, 0, 0}, {0, 0, 1}})); // 2
        System.out.println(m.maxAreaOfIsland(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}})); // 1
        System.out.println(m.maxAreaOfIsland(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0}})); // 0
        System.out.println(m.maxAreaOfIsland(new int[][]{{0, 0, 1}, {1, 1, 1}})); // 4
    }

    public int maxAreaOfIsland(int[][] grid) {
        int[] arr = new int[grid.length * grid[0].length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    int a = grid[i].length * i + j;
                    if (i - 1 >= 0 && grid[i][j] == grid[i - 1][j]) {
                        int b = grid[i - 1].length * (i - 1) + j;
                        union(arr, a, b);
                    }
                    if (j - 1 >= 0 && grid[i][j] == grid[i][j - 1]) {
                        int b = grid[i].length * i + j - 1;
                        union(arr, a, b);
                    }
                }
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            int x = j / grid[0].length;
            int y = j % grid[0].length;
            int key = getParent(arr, j);
            if (grid[x][y] != 0) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        int max = -1;
        for (int j : map.keySet()) {
            int tmp = map.get(j);
            if (tmp > max) {
                max = tmp;
            }
        }
        if (max == -1 ) {
            return 0;
        } else {
            return max;
        }
    }

    private void union(int[] arr, int a, int b) {
        int parA = getParent(arr, a);
        int parB = getParent(arr, b);

        if (parA < parB) {
            arr[parB] = arr[parA];
        } else {
            arr[parA] = parB;
        }
    }

    private int getParent(int[] arr, int a) {
        while (a != arr[a]) {
            arr[a] = arr[arr[a]];
            a = arr[a];
        }
        return a;
    }
}
