package com.codewars.leetcode.problems.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 29.08.2022
 */
public class MajorityElementRepeat  {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {2,2,1,1,1,2,2}));
    }

    public static int majorityElement(int[] nums) {

        return majorityElement(nums, 0, nums.length - 1);

    }

    public static int majorityElement(int[] nums, int start, int end) {
        if (start >= end){
            return nums[start];
        }
        int mid = start + (end - start) / 2;

        int left = majorityElement(nums, start, mid);
        int right = majorityElement(nums, mid + 1, end);

        if (left == right){
            return left;
        }
        int leftCount = getLeftCount(nums, left, start, end);
        int rightCount = getLeftCount(nums, right, start, end);

        return leftCount > rightCount ? left : right;
    }

    private static int getLeftCount(int[] nums, int num, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++){
            if (nums[i] == num){
                count ++;
            }
        }
        return count;
    }

    /**
     1 1 2
     1 1 2 2 2
     if we sort array, majority element will be in the middle of the array
     */
    public static int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int cur : nums) {
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1); // increase count
            } else {
                map.put(cur, 1); // put element first time
            }
        }

        int el = 0;
        int max = 0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if (value > max){
                max = value;
                el = key;
            }
        }
        return el;
    }
}
