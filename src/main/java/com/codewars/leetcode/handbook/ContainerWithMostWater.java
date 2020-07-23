package com.codewars.leetcode.handbook;

/*
 * Created by sgolitsyn on 6/13/20
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
//        System.out.println(c.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(c.maxArea(new int[]{4,4,2,11,0,11,5,11,13,8}));
    }

    public int maxArea(int[] height) {

        int rez = 0;
        int slow = 0;
        int fast = height.length - 1;
        while (slow < fast) {
            int curS=slow;
            int curF=fast;
            int max;
            if (height[slow] > height[fast]){
                max = height[fast --];
            } else {
                max = height[slow++];
            }

            int width = curF - curS;
            int area = max * width;
            if (area > rez) {
                rez = area;
            }
        }
        return rez;
    }
}
