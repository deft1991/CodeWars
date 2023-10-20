package com.codewars.neetcode.graph;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 20.10.2023
 */
public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        PacificAtlanticWaterFlow p = new PacificAtlanticWaterFlow();
        List<List<Integer>> lists = p.pacificAtlantic(new int[][]{
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4},
        });
        lists.forEach(l -> System.out.print(Arrays.toString(l.toArray())));
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<Pair> pac = new HashSet<>();
        Set<Pair> atl = new HashSet<>();

        int row = heights.length;
        int col = heights[0].length;

        for (int i = 0; i < col; i++){
            dfs(0, i, heights[0][i], heights, pac);
            dfs(row-1, i, heights[row-1][i], heights, atl);
        }

        for (int i = 0; i< row; i++){
            dfs(i, 0, heights[i][0], heights, pac);
            dfs(i, col - 1, heights[i][col-1], heights, atl);
        }

        List<List<Integer>> rez = new ArrayList<>();
        for (int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                Pair p = new Pair(i, j);
                if (pac.contains(p) && atl.contains(p)){
                    rez.add(List.of(i,j));
                }
            }
        }
        return rez;
    }

    private void dfs(int row, int col, int prevVal, int[][] heights, Set<Pair> ocean){
        if (row < 0 || col < 0 || row >= heights.length || col >= heights[0].length
        || ocean.contains(new Pair(row, col)) || heights[row][col] < prevVal
        ){
            return;
        }
        ocean.add(new Pair(row, col));
        dfs(row + 1, col, heights[row][col], heights, ocean);
        dfs(row -1, col, heights[row][col], heights, ocean);
        dfs(row, col + 1, heights[row][col], heights, ocean);
        dfs(row, col - 1, heights[row][col], heights, ocean);

    }

    record Pair(int i, int j){}
}
