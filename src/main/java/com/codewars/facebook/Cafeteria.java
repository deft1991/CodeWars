package com.codewars.facebook;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 14.08.2023
 */
public class Cafeteria {

    public static void main(String[] args) {
        Cafeteria c = new Cafeteria();
//        System.out.println(c.getMaxAdditionalDinersCount(10, 1, 2, new long[]{2, 6}));
        System.out.println(c.getMaxAdditionalDinersCount(15, 2, 3, new long[]{11, 6, 14}));
    }

    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        Arrays.sort(S);

        long start = 1;
        long end = S[0];
        long rez = 0;
        for (long s : S) {
            end = s;
            long freeSeats = getFreeSeats(start, end, K);
            if (freeSeats > 0) {
                rez += Math.ceil((double) freeSeats / (K + 1));
            }
            start = end + K + 1;
        }
        long freeSeats = getFreeSeats(start, N + 1, K);
        if (freeSeats > 0) {
            rez += freeSeats;
        }

        return rez;
    }

    private long getFreeSeats(long start, long end, long k) {
        return end - start - k;
    }
}
