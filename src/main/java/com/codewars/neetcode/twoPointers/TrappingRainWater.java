package com.codewars.neetcode.twoPointers;

/**
 * @author Sergey Golitsyn
 * created on 09.12.2022
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
//        System.out.println(t.trapWithMemory(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(t.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        int n = height.length;
        if (n < 3){
            return 0;
        }

        int start = 0;
        int end = n-1;
        int maxLeft = height[0];
        int maxRight = height[n-1];
        int rez = 0;
        while (start < end){

            if(height[start] < height[end]){
                start++;
                maxLeft = Math.max(maxLeft, height[start]);
                int diff = Math.min(maxLeft, maxRight) - height[start];
                if (diff > 0){
                    rez += diff;
                }
            } else {
                end --;
                maxRight = Math.max(maxRight, height[end]);
                int diff = Math.min(maxLeft, maxRight) - height[end];
                if (diff > 0){
                    rez += diff;
                }
            }
        }
        return rez;
    }

    public int trapWithMemory(int[] height) {
        int n = height.length;
        if (n < 3){
            return 0;
        }
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        int[] minMax = new int[n];
        maxLeft[1] = Math.max(0, height[0]);
        maxRight[n - 2] = Math.max(0, height[n - 1]);

        for (int i = 2; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = n - 3; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            minMax[i] = Math.min(maxLeft[i], maxRight[i]);
        }

        int[] watter = new int[n];
        for (int i = 0; i < n; i++) {
            int count = minMax[i] - height[i];
            if (count > 0) {
                watter[i] = count;
            }
        }
        int rez = 0;
        for (int i = 0; i < n; i++) {
            if (watter[i] > 0) {
                rez += watter[i];
            }
        }
        return rez;
    }
}
