package com.codewars.neetcode.stack;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 06.07.2023
 *
 * Example 1:
 * Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * Output: 3
 * Explanation:
 * The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12.
 * The car starting at 0 does not catch up to any other car, so it is a fleet by itself.
 * The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6.
 * The fleet moves at speed 1 until it reaches target.
 * Note that no other cars meet these fleets before the destination, so the answer is 3.
 *
 * Example 2:
 * Input: target = 10, position = [3], speed = [3]
 * Output: 1
 * Explanation: There is only one car, hence there is only one fleet.
 *
 * Example 3:
 * Input: target = 100, position = [0,2,4], speed = [4,2,1]
 * Output: 1
 * Explanation:
 * The cars starting at 0 (speed 4) and 2 (speed 2) become a fleet, meeting each other at 4. The fleet moves at speed 2.
 * Then, the fleet (speed 2) and the car starting at 4 (speed 1) become one fleet, meeting each other at 6.
 * The fleet moves at speed 1 until it reaches target.
 */
public class CarFleet2 {

    public static void main(String[] args) {
        CarFleet2 c = new CarFleet2();
        System.out.println(c.carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3})); // 3
        System.out.println(c.carFleet(10, new int[]{3}, new int[]{3})); // 1
        System.out.println(c.carFleet(100, new int[]{0,2,4}, new int[]{4,2,1})); // 1
    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> pairs = new ArrayList<>();
        int n = position.length;
        for(int i = 0; i < n; i++){
            Pair p = new Pair(position[i], speed[i]);
            pairs.add(p);
        }

        pairs.sort((a, b) -> Integer.compare(b.pos, a.pos));

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < n; i++){
            double time = (double) (target - pairs.get(i).pos) / pairs.get(i).speed;

           if (!stack.isEmpty() && time <= stack.peek()){
               continue;
           } else {
               stack.push(time);
           }
        }
        return stack.size();
    }

    class Pair {
        int pos;
        int speed;

        Pair(int pos, int speed){
            this.pos = pos;
            this.speed = speed;
        }
    }
}
