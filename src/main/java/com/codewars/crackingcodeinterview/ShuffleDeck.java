package com.codewars.crackingcodeinterview;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 07.06.2021
 */
public class ShuffleDeck {

    public static void main(String[] args) {
        ShuffleDeck shuffleDeck = new ShuffleDeck();

        int[] arr = {1, 2, 3, 4, 5};
        shuffleDeck.shuffle(arr);
        System.out.println(Arrays.toString(arr));
        shuffleDeck.shuffle(arr);
        System.out.println(Arrays.toString(arr));
        shuffleDeck.shuffle(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void shuffle(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int randIdx = (int) (Math.random() * (arr.length - i)) + i;
            swap(arr, i, randIdx);
        }
    }

    private void swap(int[] arr, int baseIdx, int randIdx) {
        int tmp = arr[baseIdx];
        arr[baseIdx] = arr[randIdx];
        arr[randIdx] = tmp;
    }
}
