package com.codewars.leetcode.daily;

/**
 * @author Sergey Golitsyn
 * created on 08.11.2023
 */
public class DetermineCellReachableGivenTime {

    public static void main(String[] args) {
        DetermineCellReachableGivenTime d = new DetermineCellReachableGivenTime();
        System.out.println(d.isReachableAtTime(2,4,7,7,6)); // t
        System.out.println(d.isReachableAtTime(3,1,7,3,3)); // f
        System.out.println(d.isReachableAtTime(1,2,2,1,10)); // t
        System.out.println(d.isReachableAtTime(1,2,1,1,1)); // f
    }

    /*

    2 - 7 = 5
    4 - 7 = 3

    diff = 2

     */

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int x = Math.abs(sx-fx);
        int y = Math.abs(sy - fy);
        int min = Math.min(x,y);

        int diff = Math.abs(x - y);

        return t >= min + diff + 1;
    }
}
