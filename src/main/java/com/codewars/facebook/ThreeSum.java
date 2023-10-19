package com.codewars.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 04.09.2023
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        List<List<Integer>> lists = ts.threeSum(new int[]{-1, 0, 1, 2, -1, -4});

        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rez = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i ++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int next = i + 1;
            int last = nums.length-1;

            while(next < last){
                int sum = nums[i] + nums[next] + nums[last];
                if(sum == 0){
                    rez.add(List.of(nums[i], nums[next], nums[last]));

                    while(next < last && nums[next] == nums[next+1]){
                        next++;
                    }
                    while (next < last && nums[last] == nums[last - 1]){
                        last--;
                    }
                    next++;
                    last--;

                } else if (sum > 0){
                    last--;
                } else {
                    next++;
                }
            }
        }
        return rez;
    }
}
