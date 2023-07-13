package com.codewars.neetcode.binarySearch;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 30.12.2022
 */
public class KokoEatingBananas {

    public static void main(String[] args) {
        KokoEatingBananas k = new KokoEatingBananas();
        System.out.println(k.minEatingSpeed(new int[]{3,6,7,11}, 8)); // 4
        System.out.println(k.minEatingSpeed(new int[]{30,11,23,4,20}, 5)); // 30
        System.out.println(k.minEatingSpeed(new int[]{30,11,23,4,20}, 6)); // 23
    }

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int start = 0;
        int end = piles[piles.length-1];
        int min = Integer.MAX_VALUE;
        while (start <= end){
            int mid = start + (end - start) / 2;

            int time = 0;
            for(int p : piles){
                time +=  (int) Math.ceil((double) p / mid);
            }
            if (time > h){
                start = mid + 1;
            } else {
                min = Math.min(min, mid);
                end = mid - 1;
            }
        }
        return min;
    }
}
