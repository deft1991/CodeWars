package com.codewars.neetcode.twoPointers;

/**
 * @author Sergey Golitsyn
 * created on 12.05.2023
 */
public class ContainerWithMostWater2 {

    public static void main(String[] args) {
        ContainerWithMostWater2 c = new ContainerWithMostWater2();
        System.out.println(c.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        if (height.length <= 1){
            return 0;
        }

        int start = 0;
        int end = height.length - 1;
        int rez = 0;

        while (start < end){
            int min = Math.min(height[start], height[end]);
            int length = end - start;
            int tmpSq = min * length;
            rez = Math.max(rez, tmpSq);

            if (height[start] < height[end]){
                start ++;
            } else {
                end--;
            }
        }
        return rez;
    }
}
