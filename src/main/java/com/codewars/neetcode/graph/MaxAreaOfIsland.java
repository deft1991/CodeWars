package com.codewars.neetcode.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 19.10.2023
 */
public class MaxAreaOfIsland {

    public static void main(String[] args) {
        MaxAreaOfIsland m = new MaxAreaOfIsland();
        System.out.println(m.maxAreaOfIsland(new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        }));
    }


    public int maxAreaOfIsland(int[][] grid) {
        Set<Pair> visited = new HashSet<>();
        int max = 0;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                int tmp = dfs(grid, i, j, visited);
                max = Math.max(max, tmp);
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j, Set<Pair> visited) {
        if (i < 0 || j < 0 || i >= grid.length || j > grid[i].length || grid[i][j] == 0 || visited.contains(new Pair(i, j))) {
            return 0;
        }
        visited.add(new Pair(i, j));

        int up = dfs(grid, i - 1, j, visited);
        int down = dfs(grid, i + 1, j, visited);
        int left = dfs(grid, i, j - 1, visited);
        int right = dfs(grid, i, j + 1, visited);
        return 1 + up + down + left + right;
    }

    record Pair(int i, int j) {
    }
}
