package com.codewars.neetcode.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 07.12.2022
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
//        List<List<Integer>> lists = t.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
//        List<List<Integer>> lists2 = t.threeSum(new int[]{0, 1, 1});
//        List<List<Integer>> lists3 = t.threeSum(new int[]{0, 0, 0});
        List<List<Integer>> lists4 = t.threeSum(new int[]{-2,0,0,2,2});

    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> rez = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int threeSum = nums[i] + nums[start] + nums[end];

                if (threeSum == 0) {
                    List<Integer> tmp = List.of(nums[i], nums[start], nums[end]);
                    rez.add(tmp);
                    // todo add while iteration
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    while (end > start && nums[end - 1] == nums[end]) {
                        end--;
                    }
                    start++;
                    end--;

                } else if (threeSum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return rez;
    }
}
