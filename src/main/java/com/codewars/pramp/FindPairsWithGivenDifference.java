package com.codewars.pramp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 05.05.2022
 */
public class FindPairsWithGivenDifference {
    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        if (arr.length < 2) {
            return new int[0][0];
        }
        // your code goes here

        List<List<Integer>> rez = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int j : arr) {
            map.put(j - k, j);
        }

        for (int j : arr) {
            if (map.containsKey(j)) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(map.get(j));
                tmp.add(j);
                rez.add(tmp);
            }
        }

        if (rez.size() == 0) {
            return new int[0][0];
        }
        int[][] arrRez = new int[rez.size()][2];
        for (int i = 0; i < rez.size(); i++) {
            int zeroEl = rez.get(i).get(0);
            int firstEl = rez.get(i).get(1);
            int[] tmp = new int[]{zeroEl, firstEl};
            arrRez[i] = tmp;
        }

        return arrRez;
    }

    public static void main(String[] args) {
//        int[]arr = new int [] {1, 0} ;
//        int[][] rez = findPairsWithGivenDifference(arr, 1);
//        System.out.println("Test 1: " + rez[0][0] + " " + rez[0][1]);

//        arr = new int[] {0, 1} ;
//        rez = findPairsWithGivenDifference(arr, 1);
//        System.out.println("Test 2: " + rez.length);

        int[] arr2 = new int[] {0, -1, -2, 2, 1} ;
        int[][] rez2 = findPairsWithGivenDifference(arr2, 1);
        System.out.println("Test 2: " + rez2.length);
    }

}
