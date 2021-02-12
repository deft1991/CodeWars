package com.codewars.leetcode.problems.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 12.02.2021
 * <p>
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * Output: 1
 * Example 2:
 * <p>
 * Input: grid = [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * Output: 3
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        NumberOfIslands n = new NumberOfIslands();

        System.out.println(n.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));

        System.out.println(n.numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }

    public int numIslands(char[][] grid) {
        int N = grid.length * grid[0].length;
        int nSmall = grid[0].length;
        DSU dsu = new DSU(N);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    if (i + 1 < grid.length && grid[i + 1][j] == '1') {
                        dsu.union((nSmall * i + j), (nSmall * (i + 1) + j));
                    }
                    if (j + 1 < grid[i].length && grid[i][j + 1] == '1') {
                        dsu.union((nSmall * i + j), (nSmall * i + j + 1));
                    }
                } else {
                    dsu.parent[nSmall * i + j] = -1;
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < dsu.parent.length; i++) {
            if (dsu.parent[i] != -1) {
                set.add(dsu.root(i));
            }
        }

        return set.size();

    }

    class DSU {
        private final int[] parent;
        private Set<Integer> set = new HashSet<>();

        DSU(int N) {
            parent = new int[N];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public void union(int i, int j) {
            if (!isConnected(i, j)) {
                int rootI = root(i);
                int rootJ = root(j);
                parent[rootJ] = rootI;

                if (parent[rootJ] != -1){
                    set.add(parent[rootJ]);
                }
            }

        }

        private boolean isConnected(int i, int j) {
            return root(i) == root(j);
        }

        private int root(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }
    }
}
