package com.codewars.neetcode.stack;

import java.util.Stack;

/**
 * @author Sergey Golitsyn
 * created on 23.12.2022
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        LargestRectangleInHistogram l = new LargestRectangleInHistogram();
//        System.out.println(l.largestRectangleArea(new int[]{2,4}));
        System.out.println(l.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3})); // 10
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Pair> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i < heights.length; i++){
            int startIdx = i;
            while(!stack.isEmpty() && stack.peek().value > heights[i]){
                Pair p = stack.pop();
                max = Math.max(max, (i - p.key) * p.value);
                startIdx = p.key;
            }
            stack.push(new Pair(startIdx, heights[i]));
        }

        while (!stack.isEmpty()){
            Pair p = stack.pop();
            max = Math.max(max, (heights.length - p.key) * p.value);
        }

        return max;
    }

    class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
