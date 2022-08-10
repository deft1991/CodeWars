package com.codewars.leetcode.days14;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Sergey Golitsyn
 * created on 23.02.2022
 */
public class RottingOranges {

    public static void main(String[] args) {
        RottingOranges r = new RottingOranges();
        System.out.println(r.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }

    public int orangesRotting(int[][] grid) {
        int count = 0;
        int freshCount = 0;
        int[][] positions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) {
            return count;
        }
        if (queue.isEmpty()) {
            return -1;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curPos = queue.poll();

                for (int[] position : positions) {
                    int x = curPos[0];
                    int y = curPos[1];
                    x += position[0];
                    y += position[1];

                    if (x < 0 || y < 0 || x > grid.length-1 || y > grid[x].length -1 || grid[x][y] != 1) {
                        continue;
                    }
                    freshCount--;

                    grid[x][y] = 2;
                    queue.add(new int[]{x, y});
                }
            }
            count++;
        }
        return freshCount == 0 ? count - 1 : -1;
    }
}
