package com.codewars.leetcode.problems.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 08.02.2021
 */
public class MostStonesRemovedWithSameRowOrColumn {

    public static void main(String[] args) {
        MostStonesRemovedWithSameRowOrColumn m = new MostStonesRemovedWithSameRowOrColumn();
        System.out.println(m.removeStones(new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}}));
        System.out.println(m.removeStones(new int[][]{{0,0},{0,2},{1,1},{2,0},{2,2}}));
        System.out.println(m.removeStones(new int[][]{{0,0}}));
        System.out.println(m.removeStones(new int[][]{{0, 1}, {1, 0}}));
        System.out.println(m.removeStones(new int[][]{{0, 1}, {1, 0}, {1, 1}}));
        System.out.println(m.removeStones(new int[][]{{3, 2}, {0, 0}, {3, 3}, {2, 1}, {2, 3}, {2, 2}, {0, 2}}));
    }

    public int removeStones(int[][] stones) {
        int N = stones.length;

        DSU dsu = new DSU(2000);

        for (int[] stone : stones) {
            if (!dsu.isConnected(stone[0], 1000 + stone[1])) {
                dsu.union(stone[0], 1000 + stone[1]);
            }
        }

        Set<Integer> seen = new HashSet<>();
        for (int[] stone: stones)
            seen.add(dsu.root(stone[0]));

        return N - seen.size();
    }

    class DSU {
        int[] parent;

        public DSU(int N) {
            parent = new int[N];
            for (int i = 0; i < N; ++i)
                parent[i] = i;
        }

        public boolean isConnected(int a, int b) {
            return root(a) == root(b);
        }

        public void union(int a, int b) {
            int rootA = root(a);
            int rootB = root(b);

            parent[rootB] = rootA;
        }

        private int root(int a) {
            while (a != parent[a]) {
                parent[a] = parent[parent[a]];
                a = parent[a];
            }
            return a;
        }

    }
}
