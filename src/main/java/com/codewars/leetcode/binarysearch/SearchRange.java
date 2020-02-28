package com.codewars.leetcode.binarysearch;

import java.awt.font.NumericShaper;
import java.util.Arrays;

/*
 * Created by sgolitsyn on 2/26/20
 */
public class SearchRange {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] rez = new int[2];
        rez[0] = findLeftIndex(nums, target);
        rez[1] = findRightIndex(nums, target);
        return rez;
    }

    private static int findLeftIndex(int[] nums, int target){
        int low = 0;
        int hight = nums.length - 1;
        int left = - 1;
        while (low <= hight){
            int mid = low + (hight - low)/2 ;
            if(target == nums[mid]){
                left = mid;
                hight = mid - 1;
            } else {
                if (target > nums[mid]) {
                    low = mid + 1;
                } else {
                    hight = mid - 1;
                }
            }
        }
        return left;
    }

    private static int findRightIndex(int[] nums, int target){
        int low = 0;
        int hight = nums.length - 1;
        int right = - 1;
        while (low <= hight){
            int mid = low + (hight - low)/2 ;
            if(target == nums[mid]){
                right = mid;
                low = mid + 1;
            } else {
                if (target > nums[mid]) {
                    low = mid + 1;
                } else {
                    hight = mid - 1;
                }
            }
        }
        return right;
    }
}
