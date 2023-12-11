package com.codewars.leetcode.daily;

/**
 * @author Sergey Golitsyn
 * created on 11.12.2023
 */
public class ElementAppearingMoreThan25nSortedArray {

    public static void main(String[] args) {
        ElementAppearingMoreThan25nSortedArray e = new ElementAppearingMoreThan25nSortedArray();

        System.out.println(e.findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10}));
    }

    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int[] candidates = new int[]{arr[n/4], arr[n/2], arr[3*n/4]};
        int size = n/4;

        for(int candidate : candidates){
            int left = lowerBound(arr, candidate);
            int right = upperBound(arr, candidate) - 1;

            if (right - left + 1 > size){
                return arr[left];
            }
        }
        return -1;
    }

    private int upperBound(int[] arr, int candidate) {
        int start = 0;
        int end = arr.length;

        while (start < end){
            int mid = start + (end - start) / 2;

            if (arr[mid] > candidate){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private int lowerBound(int[] arr, int candidate) {
        int start = 0;
        int end = arr.length;

        while (start < end){
            int mid = start + (end - start) / 2;

            if (arr[mid] >= candidate){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
