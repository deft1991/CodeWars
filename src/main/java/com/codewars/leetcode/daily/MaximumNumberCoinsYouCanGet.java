package com.codewars.leetcode.daily;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 24.11.2023
 */
public class MaximumNumberCoinsYouCanGet {

    public static void main(String[] args) {
        MaximumNumberCoinsYouCanGet m = new MaximumNumberCoinsYouCanGet();
        System.out.println(m.maxCoins(new int[]{2,4,1,2,7,8})); // 9
        System.out.println(m.maxCoins(new int[]{2,4,5})); // 4
        System.out.println(m.maxCoins(new int[]{9,8,7,6,5,1,2,3,4})); // 18
    }

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int start = 0;
        int end = piles.length-1;
        int my = 0;
        while (start < piles.length / 3){
            start++;
            end --;
            my+= piles[end--];
        }
        return my;
    }
}
