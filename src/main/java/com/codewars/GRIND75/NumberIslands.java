package com.codewars.GRIND75;

/**
 * @author Sergey Golitsyn
 * created on 15.09.2023
 */
public class NumberIslands {

    public static void main(String[] args) {
        NumberIslands n = new NumberIslands();
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        char[][] grid2 = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        char[][] grid3 = new char[][]{
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        };
        System.out.println(n.numIslands(grid));
        System.out.println(n.numIslands(grid2));
        System.out.println(n.numIslands(grid3));
    }

    public int numIslands(char[][] grid) {

        int count = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '-';
                    bfs(grid, i+1, j);
                    bfs(grid, i-1, j);
                    bfs(grid, i, j+1);
                    bfs(grid, i, j-1);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '-';
        bfs(grid, i+1, j);
        bfs(grid, i-1, j);
        bfs(grid, i, j+1);
        bfs(grid, i, j-1);
    }
}
