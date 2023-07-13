package com.codewars.neetcode.binarySearch;

/**
 * @author Sergey Golitsyn
 * created on 10.07.2023
 */
public class BinarySearch2 {

    public static void main(String[] args) {
        BinarySearch2 b = new BinarySearch2();
        System.out.println(b.search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(b.search(new int[]{-1,0,3,5,9,12}, 2));
        System.out.println(b.search(new int[]{-1,0,3,5,9,12}, 13));
    }

    public int search(int[] nums, int target) {
//        return binarySearch(nums, 0, nums.length-1, target);
        return binarySearch3(nums, 0, nums.length-1, target);
    }


    private int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end){
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (nums[mid] == target){
            return mid;
        } else if (nums[mid] > target){
            return binarySearch(nums, start, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, end, target);
        }
    }

    private int binarySearch3(int[] nums, int start, int end, int target) {
        while (start <= end){
            int mid = start + (end - start)/2;

            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] > target){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

}
