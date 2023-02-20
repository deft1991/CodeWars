package com.codewars.testtask;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 10.02.2023
 */
public class CorruptedFrames {

    public static void main(String[] args) {
        CorruptedFrames c = new CorruptedFrames();
        System.out.println(c.hasCorruptedWindow(new int[][]{
                {1, 1, 1, 1, 1},
                {1, 1, 2, 2, 2},
                {1, 1, 2, 1, 2},
                {1, 1, 2, 2, 2},
                {1, 1, 1, 1, 1},
        }));

    }

    /*
    If I correctly understand it.
    We can have multiple frames.
    for example 1-5. Based on the example
    if we have a frame inside another frame that is fine.
    But if we have the frame with lover number inside bigger number --> it is error.
    That is why I just want to check count of groups and compare it with count of frames. 

     */
    boolean hasCorruptedWindow(int[][] frame) {
        int N = frame.length * frame[0].length;
        int nSmall = frame[0].length;
        DSU dsu = new DSU(N);
        Set<Integer> uniqFrames = new HashSet<>();

        for (int i = 0; i < frame.length; i++) {
            for (int j = 0; j < frame[i].length; j++) {
                uniqFrames.add(frame[i][j]);
                int curFrame = frame[i][j];
                if (i + 1 < frame.length && frame[i + 1][j] == curFrame) {
                    dsu.union((nSmall * i + j), (nSmall * (i + 1) + j));
                }
                if (j + 1 < frame[i].length && frame[i][j + 1] == curFrame) {
                    dsu.union((nSmall * i + j), (nSmall * i + j + 1));
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (
                int i = 0;
                i < dsu.parent.length; i++) {
            if (dsu.parent[i] != -1) {
                set.add(dsu.root(i));
            }
        }

        int framesOnDisplay = set.size();
        return uniqFrames.size() != framesOnDisplay;
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

                if (parent[rootJ] != -1) {
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
