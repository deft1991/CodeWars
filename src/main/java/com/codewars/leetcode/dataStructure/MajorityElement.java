package com.codewars.leetcode.dataStructure;

/**
 * @author Sergey Golitsyn
 * created on 30.03.2022
 */
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement m = new MajorityElement();
        System.out.println(m.majorityElement(new int[]{3, 2, 3}));
        System.out.println(m.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        ;
    }

    public int majorityElement(int[] nums) {
        return getMajority(nums, 0, nums.length - 1);
    }

    private int getMajority(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return nums[lo];
        }

        int mid = lo + (hi - lo) / 2;
        // divide array
        int leftMajority = getMajority(nums, lo, mid);
        int rightMajority = getMajority(nums, mid + 1, hi);
        // find majority
        if (leftMajority == rightMajority) {
            return leftMajority;
        } else {
            // if diff majority find count
            int leftMajorityCount = getMajorityCount(nums, leftMajority, lo, hi);
            int rightMajorityCount = getMajorityCount(nums, rightMajority, lo, hi);
            return leftMajorityCount > rightMajorityCount ? leftMajority : rightMajority;
        }
    }

    private int getMajorityCount(int[] nums, int majority, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == majority) {
                count++;
            }
        }
        return count;
    }
}
