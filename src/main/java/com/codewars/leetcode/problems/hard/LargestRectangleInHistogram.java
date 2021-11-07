package com.codewars.leetcode.problems.hard;

import java.util.Stack;

/**
 * @author Sergey Golitsyn
 * created on 20.04.2021
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        LargestRectangleInHistogram l = new LargestRectangleInHistogram();
        System.out.println(l.largestRectangleArea(new int[]{2, 3, 4, 5, 6, 1, 7, 8, 9, 1})); // 10
        System.out.println(l.largestRectangleArea(new int[]{2, 4})); // 4
        System.out.println(l.largestRectangleArea(new int[]{0, 9})); // 9
        System.out.println(l.largestRectangleArea(new int[]{4, 2, 0, 3, 2, 4, 3, 4})); // 10
        System.out.println(l.largestRectangleArea(new int[]{2, 1, 4, 5, 1, 3, 3})); // 8
    }

    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();

        int area = 0;

        for (int i = 0; i <= heights.length; i++) {

            int height = i == heights.length ? 0 : heights[i];

            if (stack.isEmpty() || height >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int peekIdx = stack.pop();

                int length = stack.isEmpty() ? i : (i - stack.peek() - 1);
                area = Math.max(area, heights[peekIdx] * length);
                i--;
            }
        }
        return area;

    }

    public int largestRectangleArea2(int[] heights) {

        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {

            int h = (i == heights.length ? 0 : heights[i]);

            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int tp = stack.pop();
                maxArea = Math.max(maxArea, heights[tp] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
