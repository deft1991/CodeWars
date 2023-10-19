package com.codewars.GRIND75;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 15.09.2023
 */
public class NumberIslandsUnionFind {

    public static void main(String[] args) {
        NumberIslandsUnionFind n = new NumberIslandsUnionFind();
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        char[][] grid2 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        char[][] grid3 = new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        char[][] grid4 = new char[][]{
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '1', '1', '0', '1'}
        };
//        System.out.println(n.numIslands(grid));
//        System.out.println(n.numIslands(grid2));
//        System.out.println(n.numIslands(grid3));
        System.out.println(n.numIslands(grid4));
    }

    // m * i + j
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        UnionFind uf = new UnionFind(n * m);
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    if (i + 1 < n && grid[i + 1][j] == '1') {
                        int aIdx = m * i + j;
                        int bIdx = m * (i + 1) + j;
                        uf.connect(aIdx, bIdx);
                    }
                    if (j + 1 < m && grid[i][j + 1] == '1') {
                        int aIdx = m * i + j;
                        int bIdx = m * i + (j + 1);
                        uf.connect(aIdx, bIdx);
                    }
                } else {
                    uf.arr[m * i + j] = -1;
                }
            }
        }
        "".split(" ");

        Set<Integer> set = new HashSet<>();
        for (int c : uf.arr) {
            if (uf.getParent(c) != -1) {
                set.add(c);
            }
        }

        return set.size();
    }

    class UnionFind {

        private int[] arr;

        UnionFind(int length) {
            arr = new int[length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
        }

        public void connect(int a, int b) {
            int aPar = getParent(a);
            int bPar = getParent(b);
            if (aPar < bPar) {
                arr[bPar] = aPar;
            } else {
                arr[aPar] = bPar;
            }
        }

        public int getParent(int a) {
            if (a != -1) {
                while (arr[a] != a) {
                    arr[a] = arr[arr[a]];
                    a = arr[a];
                }
                return a;
            } else {
                return -1;
            }
        }
    }
}
