package com.codewars.facebook;

/**
 * @author Sergey Golitsyn
 * created on 19.08.2023
 */
public class PeakIndexMountainArray {

    public static void main(String[] args) {
        PeakIndexMountainArray p = new PeakIndexMountainArray();
        System.out.println(p.peakIndexInMountainArray(new int[]{18, 29, 38, 59, 98, 100, 99, 98, 90}));
    }

    public int peakIndexInMountainArray(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else if (arr[mid] < arr[mid - 1]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
