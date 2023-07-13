package com.codewars.hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 19.04.2023
 */
public class MinimumSegments {

    public static void main(String[] args) {
        List<Integer> a = List.of(1, 2, 5, 6, 7, 16);
        List<Integer> b = List.of(5, 4, 7, 6, 14, 19);
        System.out.println(MinimumSegments.minimumDivision(a, b, 2));

        int[] arr = new int[]{1,2,3,4};
        Arrays.sort(arr);
        System.out.println();
    }
    /*
     * Complete the 'minimumDivision' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     *  3. INTEGER k
     */

    public static int minimumDivision(List<Integer> a, List<Integer> b, int k) {
        // Write your code here
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        if (a.size() <= 1) {
            return a.size();
        }
        start.add(a.get(0));
        end.add(b.get(0));
        for (int i = 1; i < a.size(); i++) {
            int aCur = a.get(i);
            int bCur = b.get(i);

            for (int j = 0; j < start.size(); j++) {
                int aPrev = start.get(j);
                int bPrev = end.get(j);

                if (isConnected(aPrev, bPrev, aCur, bCur)) {
                    int aa = Math.min(aPrev, aCur);
                    int bb = Math.max(bPrev, bCur);
                    start.set(j, aa);
                    end.set(j, bb);
                } else {
                    start.add(aCur);
                    end.add(bCur);
                }
            }
        }
        int rez = 0;

        if (start.size() <= 1) {
            return start.size();
        }


        int bPrev = end.get(0);
        for (int i = 1; i < start.size(); i++) {
            int aCur = start.get(i);

            int dif = aCur - bPrev;
            if (dif >= k) {
                rez++;
            }
        }
        return rez + 1;

    }

    private static boolean isConnected(int aPrev, int bPrev, int aCur, int bCur) {
        if (aCur <= bPrev) {
            return true;
        } else if (bPrev >= bCur) {
            return true;
        }  else {
            return false;
        }
    }

}
