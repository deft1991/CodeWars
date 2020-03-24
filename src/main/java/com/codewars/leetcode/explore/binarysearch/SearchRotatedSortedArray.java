package com.codewars.leetcode.explore.binarysearch;

/*
 * Created by sgolitsyn on 2/11/20
 */
public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {
        return searchMy(nums, 0, nums.length - 1, target);
    }

    static int searchMy(int arr[], int low, int height, int key) {
        while (low <= height) {
            int mid = low + (height - low) / 2;

            if (arr[mid] == key) {
                return mid;
            }
            if (arr[low] == key) {
                return low;
            }
            if (arr[height] == key) {
                return height;
            }

            if (arr[mid] > arr[low]){
                if (key > arr[low] && key < arr[mid]){
                    height = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (key > arr[mid] && key < arr[height]){
                    low = mid + 1;
                } else {
                    height = mid - 1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        SearchRotatedSortedArray s = new SearchRotatedSortedArray();
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(s.search(new int[]{3, 1}, 1));
        System.out.println(s.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
        System.out.println(s.search(new int[]{8,9,2,3,4}, 9));
    }
}
