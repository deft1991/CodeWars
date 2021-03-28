package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 28.03.2021
 */
public class FlippingImage {

    public static void main(String[] args) {
        FlippingImage f = new FlippingImage();

        f.flipAndInvertImage(new int[][] {
                {1,1,0},
                {1,0,1},
                {0,0,0}
        });

        System.out.println();

        f.flipAndInvertImage(new int[][] {
                {1,1,0,0},
                {1,0,0,1},
                {0,1,1,1},
                {1,0,1,0}
        });

        System.out.println();
    }

    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] arr : image) {
            flip(arr);
            invert(arr);
        }
        return image;
    }

    private void flip(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
    }

    private void invert(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 1){
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
    }
}
