package com.codewars.leetcode.explore.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 13.11.2021
 */
public class ReplaceElementsWithGreatestElementOnRightSide {

    public static void main(String[] args) {

    }

    public int[] replaceElements(int[] arr) {

        if (arr.length < 2) {
            arr[0] = -1;
            return arr;
        }
        int lastIdx = arr.length - 1;
        int max = arr[lastIdx];

        for (int i = lastIdx - 1; i >= 0; i --){
            int tmp = arr[i];
            arr[i] = max;

            if (tmp > max) {
                max = tmp;
            }
        }

        arr[arr.length - 1] = -1;
        return arr;
    }

    public int[] replaceElements2(int[] arr) {
        if (arr.length < 2) {
            arr[0] = -1;
            return arr;
        }
        Map<Integer, Integer> maxMap = new HashMap<>();

        for (int i = 0; i < arr.length; i ++) {
            int maxVal = 0;

            for (int j = arr.length - 1; j > i; j --) {
                if (arr[j] > maxVal) {
                    maxVal = arr[j];
                }
            }
            maxMap.put(i, maxVal);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = maxMap.get(i);
        }

        arr[arr.length - 1] = -1;
        return arr;
    }
}
