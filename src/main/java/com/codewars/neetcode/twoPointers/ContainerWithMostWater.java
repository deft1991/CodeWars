package com.codewars.neetcode.twoPointers;

/**
 * @author Sergey Golitsyn
 * created on 09.12.2022
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        System.out.println(c.maxAreaBrutForce(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(c.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] height) {

        if (height.length == 0) {
            return 0;
        }
        if (height.length == 1) {
            return 0;
        }

        int max = 0;
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            int square = (end - start) * Math.min(height[start], height[end]);
            max = Math.max(square, max);
            if (height[start] > height[end]){
                end --;
            } else if (height[start] < height[end]){
                start ++;
            } else {
                if(height[start+1] > height[end-1]){
                    start++;
                } else {
                    end --;
                }
            }
        }
        return max;
    }

    public int maxAreaBrutForce(int[] height) {

        if (height.length == 0) {
            return 0;
        }
        if (height.length == 1) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int square = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(square, max);
            }
        }
        return max;
    }
}
