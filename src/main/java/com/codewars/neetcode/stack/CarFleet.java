package com.codewars.neetcode.stack;

import java.util.Comparator;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author Sergey Golitsyn
 * created on 22.12.2022
 */
public class CarFleet {

    public static void main(String[] args) {
        CarFleet c = new CarFleet();
//        System.out.println(c.carFleet(10, new int[]{3}, new int[]{3})); // 1
        System.out.println(c.carFleet(100, new int[]{0, 2, 4}, new int[]{4, 2, 1})); // 1
        System.out.println(c.carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3})); // 3
    }

    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < position.length; i++) {
            map.put(position[i], speed[i]);
        }

        Stack<Double> stack = new Stack<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            double curTime = (double) (target - entry.getKey()) / entry.getValue();

            if (!stack.isEmpty() && curTime <= stack.peek()){
                continue;
            } else {
                stack.push(curTime);
            }
        }
        return stack.size();
    }
}
