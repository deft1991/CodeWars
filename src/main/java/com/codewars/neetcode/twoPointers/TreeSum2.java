package com.codewars.neetcode.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 09.05.2023
 */
public class TreeSum2 {

    public static void main(String[] args) {
        TreeSum2 ts = new TreeSum2();
//        ts.threeSum(new int[]{-1, 0, 1, 2, -1, -4}).forEach(el -> System.out.print(Arrays.toString(el.toArray())));
        System.out.println();
//        ts.threeSum(new int[]{0,0,0}).forEach(el -> System.out.print(Arrays.toString(el.toArray())));
        System.out.println();
//        ts.threeSum(new int[]{0,1,1}).forEach(el -> System.out.print(Arrays.toString(el.toArray())));
        System.out.println();
        ts.threeSum(new int[]{0, 0, 0, 0}).forEach(el -> System.out.print(Arrays.toString(el.toArray())));
        System.out.println();
    }


    /*
    a + b + c = 0

    -1 -1 0 1 2
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        List<List<Integer>> rez = new ArrayList<>();
        for (int start = 0; start < n - 2; start++) {
            if (start > 0 && nums[start] == nums[start - 1]) {
                continue;
            }
            int middle = start + 1;
            int end = n - 1;

            while (middle < end) {
                int a = nums[start];
                int b = nums[middle];
                int c = nums[end];
                int sum = a + b + c;
                if (sum == 0) {
                    List<Integer> tmp = List.of(a, b, c);
                    rez.add(tmp);
                    middle++;
                    while (middle < end && nums[middle] == nums[middle-1]){
                        middle++;
                    }
                    end --;
                    while(end > middle && nums[end] == nums[end+1]){
                        end--;
                    }
                } else if (sum > 0) {
                    end--;
                } else {
                    middle++;
                }
            }
        }
        return rez;
    }
}
