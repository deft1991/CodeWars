package com.codewars.neetcode.binarySearch;

/**
 * @author Sergey Golitsyn
 * created on 07.12.2023
 */
public class KokoEatingBananas2 {

    public static void main(String[] args) {
        KokoEatingBananas2 k = new KokoEatingBananas2();
        System.out.println(k.minEatingSpeed(new int[]{2, 2}, 2)); // 2
//        System.out.println(k.minEatingSpeed(new int[]{3,6,7,11}, 8)); // 4
//        System.out.println(k.minEatingSpeed(new int[]{30,11,23,4,20}, 5)); // 30
//        System.out.println(k.minEatingSpeed(new int[]{30,11,23,4,20}, 6)); // 23
    }

    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = findMax(piles);
        int rez = end;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canFinish(piles, mid, h)) {
                rez = Math.min(rez, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return rez;
    }

    private boolean canFinish(int[] piles, int mid, int h) {
        int curTime = 0;
        for (int pile : piles) {

            curTime += (int) Math.ceil((double) pile / mid);

            if (curTime > h) {
                return false;
            }
        }
        return curTime <= h;
    }

    private int findMax(int[] piles) {
        int max = 0;

        for (int el : piles) {
            max = Math.max(max, el);
        }
        return max;
    }
}
