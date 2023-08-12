package com.codewars.GRIND75;

/**
 * @author Sergey Golitsyn
 * created on 17.07.2023
 */
public class FloodFill {

    public static void main(String[] args) {
        FloodFill ff = new FloodFill();
        int[][]matrix = new int[][] {
            {1,1,1},
            {1,1,0},
            {1,0,1}
        };
        int[][] ints = ff.floodFill(matrix, 1, 1, 2);
        System.out.println();
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        fill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int newColor, int base) {
        if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[sr].length && image[sr][sc] != newColor) {
            if (image[sr][sc] == base) {
                image[sr][sc] = newColor;
                fill(image, sr + 1, sc, newColor, base);
                fill(image, sr - 1, sc, newColor, base);
                fill(image, sr, sc + 1, newColor, base);
                fill(image, sr, sc - 1, newColor, base);
            }
        }
    }
}
