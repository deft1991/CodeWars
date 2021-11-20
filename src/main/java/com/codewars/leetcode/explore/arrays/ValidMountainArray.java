package com.codewars.leetcode.explore.arrays;

/**
 * @author Sergey Golitsyn
 * created on 13.11.2021
 */
public class ValidMountainArray {

    public static void main(String[] args) {
        ValidMountainArray v = new ValidMountainArray();
        int[] arr = {3, 5, 5};
        System.out.println(v.validMountainArray(arr)); // false

        arr = new int[]{2, 1};
        System.out.println(v.validMountainArray(arr)); // false

        arr = new int[]{0, 3, 2, 1};
        System.out.println(v.validMountainArray(arr)); // true
    }

    public boolean validMountainArray(int[] arr) {

        if (arr.length < 3) {
            return false;
        }

        int isIncrease = -1;
        int isDecrease = -1;

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] < arr[i + 1]) {
                if (isIncrease == -1) {
                    isIncrease = 1;
                }
                if (isDecrease == 1) {
                    return false;
                }
            } else if (arr[i] > arr[i + 1]) {
                if (isDecrease == -1) {
                    isDecrease = 1;
                }
            } else {
                return false;
            }
        }
        return isIncrease == 1 && isDecrease == 1;
    }
}
