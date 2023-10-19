package com.codewars.facebook;

/**
 * @author Sergey Golitsyn
 * created on 21.08.2023
 */
public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        SearchRotatedSortedArray s = new SearchRotatedSortedArray();
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 0)); // 4
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 3)); // -1
        System.out.println(s.search(new int[]{1,3}, 3)); // 1
    }

    public int search(int[] nums, int target) {
        int pivot = getMinElementIdx(nums);
        if (nums[pivot] == target) {
            return pivot;
        }
        int left = search(nums, 0, pivot, target);
        if(left != -1){
            return left;
        }
        int right = search(nums, pivot, nums.length-1, target);
        return right;
    }

    private int search(int[] nums, int from, int to, int target) {
        while(from <= to){
            int mid = from + (to - from) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                to = mid - 1;
            } else {
                from = mid + 1;
            }
        }
        return -1;
    }

    private int getMinElementIdx(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[start] >= nums[end]) { // unsorted
                if (nums[mid] >= nums[start]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else {
                end = mid;
            }
        }
        return start;
    }
}
