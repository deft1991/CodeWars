package com.codewars.pramp;

/*
 * Created by sgolitsyn on 1/21/20
 */
public class ShiftedArraySearch {

    public static void main(String[] args) {
        // int[] nums = new int []{1,2,3,4,5};
        // System.out.println(binarySearch(nums, 3, 0, nums.length));

        int[] num2 = new int[]{3, 4, 5, 6, 1, 2};
        System.out.println(shiftedArrSearch(num2, 2));

        int[] num3 = new int[]{9, 12, 17, 2, 4, 5};
        System.out.println(shiftedArrSearch(num3, 2));

    }

    // 1,2,3,4,5,6
    static int search(int[] nums, int key, int left, int right) {
        if(left > right){
            return -1;
        }
        int mid = (left + right)/2;

        if(nums[mid] == key){
            return mid;
        }
        if(nums[mid] > nums[left]){
            if(key >= nums[left] && key <= nums[mid]){
                return search(nums, key, left, mid - 1);
            } else {
                return search(nums, key, mid + 1, right);
            }
        } else {
            if(key <= nums[right] && key >= nums[mid]){
                return search(nums, key, mid + 1, right);
            } else {
                return search(nums, key, left, mid - 1);
            }
        }
    }

    // 1,2,3,4,5,6
    static int shiftedArrSearch(int[] shiftArr, int num) {
        // your code goes here
        return search(shiftArr, num, 0, shiftArr.length - 1);
    }

}
