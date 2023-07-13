package com.codewars.pramp;

/**
 * @author Sergey Golitsyn
 * created on 14.02.2023
 */
public class ShortestCellPath {

    static int minCount = Integer.MAX_VALUE;
    static int TR = 0;
    static int TC = 0;

    public static void main(String[] args) {
        // 0,0 | 2,0 | rez = 8
        int[][] grid = new int [][]{
                {1, 1, 1, 1},
                {0, 0, 0, 1},
                {1, 1, 1, 1}
        };

        int rez = shortestCellPath(grid, 0, 0, 2, 0);
        System.out.println(rez);
    }

    static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        // your code goes here

        minCount = Integer.MAX_VALUE;
        TR = tr;
        TC = tc;
        bfs(grid, sr, sc, 0);
        return minCount == Integer.MAX_VALUE ? -1 :  minCount;

    }

    private static void bfs (int[][] grid, int sr, int sc, int count){
        if(sr >= 0 && sr < grid.length && sc >= 0 && sc < grid[0].length){
            if(grid[sr][sc] == 1){

                if(TR == sr && TC == sc){
                    minCount = Math.min(minCount, count + 1);
                    return;
                } else {
                    grid[sr][sc] = 0;
                    bfs(grid, sr + 1, sc, count + 1);
                    bfs(grid, sr - 1, sc, count + 1);
                    bfs(grid, sr, sc + 1, count + 1);
                    bfs(grid, sr, sc - 1, count + 1);
                }
            } else {
                return;
            }
        } else {
            return;
        }
    }


}
