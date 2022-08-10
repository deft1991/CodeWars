package com.codewars.leetcode.days14;

/**
 * @author Sergey Golitsyn
 * created on 13.03.2022
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        System.out.println(c.maxArea(new int[] {1,8,6,2,5,4,8,3,7})); // 49
        System.out.println(c.maxArea(new int[] {1,1})); // 1
    }

    public int maxArea(int[] height) {

        if (height.length == 0) {
            return 0;
        }
        if (height.length == 1) {
            return 0;
        }

        int start = 0;
        int end = height.length - 1;
        int max = 0;
        while (start < end) {
            int min = Math.min(height[start], height[end]);

            int cur = min * (end - start);

            if (cur > max) {
                max = cur;
            }
            if (height[start] < height[end]) {
                start++;
            } else if (height[start] > height[end]) {
                end--;
            } else {
                if (start + 1 < height.length && height[start + 1] < height[end - 1]) {
                    start++;
                } else if (height[start + 1] > height[end - 1]) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return max;
    }
}
