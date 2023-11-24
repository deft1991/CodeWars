package com.codewars.leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 23.11.2023
 */
public class ArithmeticSubarrays {

    public static void main(String[] args) {
        ArithmeticSubarrays a = new ArithmeticSubarrays();
        System.out.println(Arrays.toString(
                a.checkArithmeticSubarrays(
                                new int[]{4, 6, 5, 9, 3, 7},
                                new int[]{0, 0, 2},
                                new int[]{2, 3, 5})
                        .toArray()));

        System.out.println(Arrays.toString(
                a.checkArithmeticSubarrays(
                                new int[]{-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10},
                                new int[]{0,1,6,4,8,7},
                                new int[]{4,4,9,7,9,10})
                        .toArray()));
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> rez = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            int start = l[i];
            int end = r[i];

            int[] arr = new int[end - start + 1];
            int idx = 0;
            for (int j = start; j <= end; j++) {
                arr[idx++] = nums[j];
            }
            Arrays.sort(arr);
            int diff = arr[1] - arr[0];
            boolean isCorrect = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j + 1] - arr[j] != diff) {
                    isCorrect = false;
                    break;
                }
            }
            rez.add(isCorrect);
        }
        return rez;
    }
}
