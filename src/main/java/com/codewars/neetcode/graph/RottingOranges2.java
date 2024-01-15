package com.codewars.neetcode.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Sergey Golitsyn
 * created on 15.01.2024
 */
public class RottingOranges2 {

    public static void main(String[] args) {
        RottingOranges2 r = new RottingOranges2();
//        System.out.println(r.orangesRotting(new int[][]{
//                {2,1,1},
//                {1,1,0},
//                {0,1,1},
//        }));
//        System.out.println(r.orangesRotting(new int[][]{
//                {2,1,1},
//                {0,1,1},
//                {1,0,1},
//        }));
//        System.out.println(r.orangesRotting(new int[][]{
//                {0,0,2},
//        }));
        System.out.println(r.orangesRotting(new int[][]{
                {0},
        }));
    }

    public int orangesRotting(int[][] grid) {
        Queue<Point> q = new ArrayDeque<>();
        int time = 0;
        int fresh = 0;
        for (int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == 2){
                    q.add(new Point(i, j));
                }
                if (grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        while (!q.isEmpty()){
            int size = q.size();
            time++;
            for (int i = 0; i < size; i++){
                Point point = q.poll();
                fresh--;
                dfs(point.row + 1,point.col, grid, q);
                dfs(point.row - 1,point.col, grid, q);
                dfs(point.row,point.col + 1, grid, q);
                dfs(point.row,point.col - 1, grid, q);
            }
        }

        if (fresh == -1){
            return time - 1;
        }
        return -1;
    }

    private void dfs(int row, int col, int[][]grid, Queue<Point> q){
        if (row < 0 || row >= grid.length
        || col < 0 || col >= grid[0].length
        || grid[row][col] != 1){
            return;
        }
        grid[row][col] = 2;
        q.add(new Point(row, col));
    }

    record Point(int row, int col){}
}
