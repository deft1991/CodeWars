package com.codewars.leetcode.daily;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 15.02.2024
 */
public class FindPolygonWithLargestPerimeter {

    public static void main(String[] args) {
        FindPolygonWithLargestPerimeter f = new FindPolygonWithLargestPerimeter();
        System.out.println(f.largestPerimeter(new int[]{1,12,1,2,5,50,3}));
        System.out.println(f.largestPerimeter(new int[]{5,5,5}));
    }

    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        int start = 0;
        int end = 2;
        int max = -1;
        while(end < nums.length){
            if(nums[end - 2] + nums[end - 1] >= nums[end]){

            } else {
                int sum = 0;
                if(end - start >= 3){
                    while(start < end){
                        sum += nums[start++];
                    }
                    max = Math.max(max, sum);
                } else {
                    start = end;
                }

            }
            end++;
        }

        return max;
    }
}
