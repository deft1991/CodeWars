package com.codewars.leetcode.problems.medium;

/**
 * @author Sergey Golitsyn
 * created on 08.02.2021
 */
public class MostStonesRemovedWithSameRowOrColumn {

    public static void main(String[] args) {
        MostStonesRemovedWithSameRowOrColumn m = new MostStonesRemovedWithSameRowOrColumn();
//        System.out.println(m.removeStones(new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}}));
//        System.out.println(m.removeStones(new int[][]{{0,0},{0,2},{1,1},{2,0},{2,2}}));
//        System.out.println(m.removeStones(new int[][]{{0,0}}));
        System.out.println(m.removeStones(new int[][]{{0, 1}, {1, 0}}));
//        System.out.println(m.removeStones(new int[][]{{0, 1}, {1, 0}, {1, 1}}));
//        System.out.println(m.removeStones(new int[][]{{3, 2}, {0, 0}, {3, 3}, {2, 1}, {2, 3}, {2, 2}, {0, 2}}));
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        int m = stones[0].length;

        new DSU(n * m);


        return 0;
    }

    class DSU {
        int[] parent;

        public DSU(int N) {
            parent = new int[N];
            for (int i = 0; i < N; ++i)
                parent[i] = i;
        }

        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
}
