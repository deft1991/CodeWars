package com.codewars.leetcode.array;

import java.util.Arrays;

/*
 * Created by sgolitsyn on 4/30/20
 */
public class DuplicateZeros {

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,2,3,0,4,5,0};
        new DuplicateZeros().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void duplicateZeros(int[] arr) {
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        int j = 0;
        for(int i = 0; i < copy.length - 1 && j <= copy.length - 1 ; i ++){
            arr[j++] = copy[i];
            if (copy[i] == 0 && j <= copy.length - 1){
                arr[j++] = 0;
            }
        }
    }
}
