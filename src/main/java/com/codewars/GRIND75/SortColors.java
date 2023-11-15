package com.codewars.GRIND75;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 09.11.2023
 */
public class SortColors {

    public static void main(String[] args) {
        SortColors s = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int [] {2, 0, 1};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;

        for(int color : nums){
            switch (color){
                case 0:
                    red++;
                    break;
                case 1:
                    white++;
                    break;
                case 2:
                    blue++;
                    break;
            }
        }
        int point = 0;
        while(red > 0){
            nums[point++] = 0;
            red--;
        }
        while(white > 0){
            nums[point++] = 1;
            white--;
        }
        while(blue > 0){
            nums[point++] = 2;
            blue--;
        }
    }
}
