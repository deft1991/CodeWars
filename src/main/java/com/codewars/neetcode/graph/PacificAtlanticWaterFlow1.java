package com.codewars.neetcode.graph;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 11.01.2024
 */
public class PacificAtlanticWaterFlow1 {

    public static void main(String[] args) {
        PacificAtlanticWaterFlow1 p = new PacificAtlanticWaterFlow1();

        List<List<Integer>> lists = p.pacificAtlantic(new int[][]{
                {1, 1},
                {1, 1},
                {1, 1},
        });

        lists.forEach(l -> System.out.println(Arrays.toString(l.toArray())));
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<Point> pacific = new HashSet<>();
        Set<Point> atlantic = new HashSet<>();

        int row = heights.length;
        int col = heights[0].length;

        for (int i = 0; i < col; i++) {
            dfs(0, i, heights, pacific, heights[0][i]);

            dfs(row - 1, i, heights, atlantic, heights[row-1][i]);
        }

        for (int i = 0; i < row; i++) {
            dfs(i, 0, heights, pacific, heights[i][0]);

            dfs(i, col - 1, heights, atlantic, heights[i][col-1]);
        }

        List<List<Integer>> rez = new ArrayList<>();
        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[i].length; j++){
                Point p = new Point(i, j);
                if (pacific.contains(p) && atlantic.contains(p)){
                    rez.add(List.of(i, j));
                }
            }
        }
        return rez;
    }

    private void dfs(int row, int col, int[][] heights, Set<Point> points, int val) {
        if (row < 0 || row >= heights.length
                || col < 0 || col >= heights[0].length
                || points.contains(new Point(row, col))
                || val > heights[row][col]) {
            return;
        }
        points.add(new Point(row, col));
        val = heights[row][col];
        dfs(row + 1, col, heights, points, val);
        dfs(row - 1, col, heights, points, val);
        dfs(row, col + 1, heights, points, val);
        dfs(row, col - 1, heights, points, val);
    }

    record Point(int row, int col) {
    }
}
