package com.codewars.leetcode.days14;

/**
 * @author Sergey Golitsyn
 * created on 20.02.2022
 */
public class FloodFill {

    public static void main(String[] args) {
        FloodFill ff = new FloodFill();
        int[][] ints = new int[0][0];
        ints = ff.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);
        ints = ff.floodFill(new int[][]{{1,1,1}, {1,1,1}}, 1, 1, 2);
        ints = ff.floodFill(new int[][]{{1,1,1}, {1,1,1}, {1,1,1}}, 1, 1, 2);
        ints = ff.floodFill(new int[][]{{0,0,0}, {0,1,1}}, 1, 1, 2);
        ints = ff.floodFill(new int[][]{{0,0,1}, {1,1,1}}, 1, 0, 2);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int[] arr = new int[image.length * image[0].length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                int cur = image[i].length * i + j;
                if (i - 1 >= 0 && image[i][j] == image[i - 1][j]) {
                    int prev = image[i - 1].length * (i - 1) + j;
                    union(arr, cur, prev);
                }
                if (j - 1 >= 0 && image[i][j] == image[i][j - 1]) {
                    int prev = image[i].length * i + j - 1;
                    union(arr, cur, prev);
                }
            }
        }

        int idx = image[sr].length * sr + sc;
        int parent = getParent(arr, idx);

        for (int i = 0; i < arr.length; i++) {
            if (parent == getParent(arr, arr[i])) {
                int x = i / image[0].length;
                int y = i % image[x].length;
                image[x][y] = newColor;
            }
        }
        return image;
    }

    private void union(int[] arr, int a, int b) {
        int parA = getParent(arr, a);
        int parB = getParent(arr, b);
        if (parA < parB){
            arr[parB] = parA;
        } else {
            arr[parA] = parB;
        }

    }

    private int getParent(int[] arr, int a) {
        while (a != arr[a]) {
            arr[a] = arr[arr[a]];
            a = arr[a];
        }
        return a;
    }
}
