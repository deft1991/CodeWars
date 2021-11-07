package com.codewars.crackingcodeinterview;

/**
 * @author Sergey Golitsyn
 * created on 07.06.2021
 */
public class RandomSeq {

    public static void main(String[] args) {

    }

    public int[] randomSeq(int[] arr, int n) {

        int[] copyArr = arr.clone();

        for (int i = 0; i < n; i++) {
            int randIdx = generateRandIdx(i, n - 1);
            copyArr[i] = arr[randIdx];
            arr[randIdx] = arr[i];
        }
        return copyArr;
    }

    private int generateRandIdx(int lower, int upper) {
        return lower + (int) (Math.random() * (upper - lower + 1));
    }
}
