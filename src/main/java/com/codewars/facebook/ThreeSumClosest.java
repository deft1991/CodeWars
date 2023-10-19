package com.codewars.facebook;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 04.09.2023
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        ThreeSumClosest ts = new ThreeSumClosest();

        System.out.println(ts.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println(ts.threeSumClosest(new int[]{0,0,0}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Integer rez = null;
        Integer diff = null;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            int start = i+1;
            int end = nums.length-1;

            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];

                if(rez == null){
                    rez = sum;
                    diff = target - sum;
                } else {
                    int tmpDiff = Math.abs(target - sum);
                    if(tmpDiff == 0){
                        return target;
                    }
                    if(tmpDiff < diff){
                        rez = sum;
                        diff = tmpDiff;
                    }
                    if(tmpDiff < 0){
                        start ++;
                    } else {
                        end --;
                    }
                }
            }

        }
        return rez;
    }
}
