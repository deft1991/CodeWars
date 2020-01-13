package com.codewars.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Created by sgolitsyn on 1/10/20
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        IntersectionOfTwoArrays intersection = new IntersectionOfTwoArrays();
        System.out.println(Arrays.toString(intersection.intersect(nums1, nums2)));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        List<Integer> rezList = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if (nums1.length > nums2.length) {
            addDuplicate(nums2, nums1, rezList);
        } else {
            addDuplicate(nums1, nums2, rezList);
        }
        return rezList.stream().mapToInt(i -> i).toArray();
    }

    private void addDuplicate(int[] nums1, int[] nums2, List<Integer> rezList) {
        for (int i = 0; i < nums1.length;) {
            for (int j = 0; j < nums2.length;) {
                if (nums1[i] == nums2[j]) {
                    rezList.add(nums1[i]);
                    i++;
                    j++;
                } else if (nums1[i] > nums2[j]) {
                    j++;
                } else {
                    i++;
                }
                if (i == nums1.length || j == nums2.length){
                    return;
                }
            }
        }
    }
}
