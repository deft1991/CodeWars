package com.codewars.GRIND75;

/**
 * @author Sergey Golitsyn
 * created on 19.09.2023
 */
public class SearchRotatedSortedArray2 {

    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            // 12345
            if (nums[start] <= nums[mid]) { // sorted
               if(target < nums[start] || target > nums[mid]){
                   start = mid + 1;
               } else {
                   end = mid - 1;
               }
                // nums[start] >= nums[mid]
            } else { // 561234
                if(target < nums[end] || target < nums[mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }


}
