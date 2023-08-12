package com.codewars.neetcode.slindingwindow;

import java.util.Stack;

/**
 * @author Sergey Golitsyn
 * created on 26.07.2023
 */
public class LargestRectangleHistogram2 {

    public static void main(String[] args) {
        LargestRectangleHistogram2 l = new LargestRectangleHistogram2();
        System.out.println(l.largestRectangleArea(new int[]{2,1,5,6,2,3})); // 10
        System.out.println(l.largestRectangleArea(new int[]{2,4})); // 4
        System.out.println(l.largestRectangleArea(new int[]{1,2,1})); // 3
        System.out.println(l.largestRectangleArea(new int[]{2,1,2})); // 3
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Pair> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek().val > heights[i]) {
                Pair pop = stack.pop();
                max = Math.max(max, pop.val * (i - pop.idx));
                start = pop.idx;
            }
            stack.push(new Pair(start, heights[i]));
        }

        while (!stack.isEmpty()) {
            Pair pop = stack.pop();
            max = Math.max(max, pop.val * (heights.length - pop.idx));
        }

        return max;
    }

    class Pair{
        int idx;
        int val;

        Pair(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
}
