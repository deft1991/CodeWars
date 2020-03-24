package com.codewars.leetcode.explore.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Created by sgolitsyn on 2/27/20
 */
public class FindKClosestElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findClosestElements(new int[]{1,2,3,4,5}, 4,3).toArray()));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> rez = new ArrayList<>();
        int targetIdx = findTargetIdx(arr, x);
        if  (targetIdx < 0){
            int i = 0;
            while(k >= i){
                rez.add(arr[i++]);
            }
            return rez;
        }

        int leftCount = targetIdx - k;
        if (leftCount < 0){
            int i = 0;
            while(k > i){
                rez.add(arr[i++]);
            }
        } else {
            while(k > 0){
                rez.add(arr[targetIdx - k]);
                k--;
            }
            return rez;
        }
        return rez;
    }

    private static int findTargetIdx(int[] arr, int target) {
        int low = 0;
        int hight = arr.length - 1;

        while(low < hight){
            int mid = low + (hight - low)/2;

            if (target == arr[mid]){
                return mid;
            } else {
                if (target < arr[mid]){
                    hight = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
