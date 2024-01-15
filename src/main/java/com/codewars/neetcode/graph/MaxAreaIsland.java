package com.codewars.neetcode.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 08.01.2024
 */
public class MaxAreaIsland {

    public static void main(String[] args) {
        MaxAreaIsland m = new MaxAreaIsland();
        System.out.println(m.maxAreaOfIsland(new int[][]{
                {1,1,0},
                {1,0,0},
                {0,0,1},
        }));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int tmp = bfs(i, j, grid);
                max = Math.max(tmp, max);
            }
        }
        return max;
    }

    private int bfs(int row, int col, int[][] grid) {
        if (row >= 0 && row < grid.length
                && col >= 0 && col < grid[0].length
                && grid[row][col] == 1) {
            grid[row][col] = 0;
         return bfs(row + 1, col, grid) +
            bfs(row - 1, col, grid) +
            bfs(row, col + 1, grid) +
            bfs(row, col - 1, grid) + 1;
        }
        return 0;
    }

}
