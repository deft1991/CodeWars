package com.codewars.neetcode.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 06.01.2024
 */
public class NumberIslands {

    public static void main(String[] args) {
        NumberIslands n = new NumberIslands();
        System.out.println(n.numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        }));
    }

    public int numIslands(char[][] grid) {
        Set<Pair> visited = new HashSet<>();
        int rez = 0;

        int[][] direction = new int[][]{
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1' && !visited.contains(new Pair(row, col))) {
                    rez++;
                    bfs(row, col, grid, visited, direction);
                }
            }
        }
        return rez;
    }

    private void bfs(int row, int col, char[][] grid, Set<Pair> visited, int[][] direction) {

        visited.add(new Pair(row, col));

        for (int[] ints : direction) {
            int nRow = row + ints[0];
            int nCol = col + ints[1];

            if (nRow >= 0 && nRow < grid.length
                    && nCol >= 0 && nCol < grid[0].length
                    && grid[nRow][nCol] == '1'
                    && !visited.contains(new Pair(nRow, nCol))) {
                bfs(nRow, nCol, grid, visited, direction);
            }
        }
    }

    record Pair(int row, int col) {
    }
}
