package com.codewars.neetcode.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Sergey Golitsyn
 * created on 23.10.2023
 */
public class RottingOranges {

    public static void main(String[] args) {
        RottingOranges r = new RottingOranges();
        System.out.println(r.orangesRotting(new int[][]{
                {2,1,1},
                {1,1,0},
                {0,1,1},
        }));
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new ArrayDeque<>();
        int freshCount = 0;
        int time = 0;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    freshCount++;
                } else if (grid[i][j] == 2){
                    q.add(new Pair(i, j));
                }
            }
        }
        if (freshCount == 0){
            return 0;
        }
        if (q.isEmpty()){
            return -1;
        }
        while (!q.isEmpty()){
            time++;
            int count = q.size();
            for (int i = 0; i < count; i++){
                Pair p = q.poll();
                if (p.row - 1 >= 0 && grid[p.row - 1][p.col] == 1){
                    freshCount--;
                    q.add(new Pair(p.row - 1, p.col));
                    grid[p.row - 1][p.col] = 2;
                }
                if (p.row + 1 < grid.length && grid[p.row + 1][p.col] == 1){
                    freshCount--;
                    q.add(new Pair(p.row + 1, p.col));
                    grid[p.row + 1][p.col] = 2;
                }
                if (p.col - 1 >= 0 && grid[p.row][p.col - 1] == 1){
                    freshCount--;
                    q.add(new Pair(p.row, p.col - 1));
                    grid[p.row][p.col - 1] = 2;
                }
                if (p.col + 1 < grid[0].length && grid[p.row][p.col + 1] == 1){
                    freshCount--;
                    q.add(new Pair(p.row, p.col + 1));
                    grid[p.row][p.col + 1] = 2;
                }
            }
        }
        return freshCount == 0 ? time - 1 : -1;
    }

    record Pair(int row, int col){}
}
