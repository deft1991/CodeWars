package com.codewars.neetcode.binarySearch;

/**
 * @author Sergey Golitsyn
 * created on 12.12.2023
 */
public class FindMinimumRotatedSortedArray2 {

    public static void main(String[] args) {
        FindMinimumRotatedSortedArray2 f = new FindMinimumRotatedSortedArray2();
//        System.out.println(f.findMin(new int[]{3,4,5,1,2}));
//        System.out.println(f.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(f.findMin(new int[]{1}));
    }

    /**
     * 3,4,5,1,2 --> 1
     * 4,5,6,7,0,1,2 --> 0
     */
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int min = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            min = Math.min(min, nums[mid]);
            if (nums[start] < nums[end]){ // sorted
                if (nums[mid] >= nums[start]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                min = Math.min(min, nums[start]);
            } else { // unsorted
                if (nums[mid] >= nums[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return min;
    }
}
