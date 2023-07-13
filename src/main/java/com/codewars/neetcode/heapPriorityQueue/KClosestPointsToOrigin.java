package com.codewars.neetcode.heapPriorityQueue;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 23.02.2023
 */
public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        KClosestPointsToOrigin k = new KClosestPointsToOrigin();
//        int[][] rez = k.kClosest(new int[][]{
//                {60, 100},
//                {34, 84}
//        }, 2);
//        int[][] rez = k.kClosest(new int[][]{
//                {3, 3},
//                {5, -1},
//                {-2, 4}
//        }, 2);
//        int[][] rez = k.kClosest(new int[][]{
//                {68, 97},
//                {34, -84},
//                {60, 100},
//                {-57, -67},
//                {-55, -39},
//                {-27, -38},
//                {2, 31},
//                {-73, -74},
//                {62, 91},
//                {62, 92},
//        }, 5);

        int[][] rez = k.kClosest(new int[][]{
                {-66,42},
                {-67,94},
                {46,10},
                {35,27},
                {-9,-6},
                {-84,-97},
                {38,-22},
                {3,-39},
                {71,-97},
                {-40,-86},
                {-45,56},
                {-91,59},
                {24,-11},
                {91,100},
                {-68,43},
                {34,27},
        }, 6);
        for (int[] q : rez){
            System.out.println(Arrays.toString(q));
        }


    }

    public int[][] kClosest(int[][] points, int k) {
        Heap heap = new Heap(k);

        for(int[] point : points){
            heap.add(point[0], point[1]);
        }
        int[][] rez = new int[k][2];

        for (int i =0; i < k; i ++){
            Pair max = heap.getMax();
            rez[i] = new int[]{max.x, max.y};
        }
        return rez;
    }

    private class Heap {
        private double[] arr;
        private Map<Double, List<Pair>> map;
        private int N;

        Heap(int length) {
            N = 1;
            arr = new double[length + 1];
            map = new HashMap<>();
        }

        public void add(int x, int y) {
            double distance = getDistance(x, y);
            Pair p = new Pair(x, y);

            if (N < arr.length){
                arr[N++] = distance;
                pupValueToMap(distance, p);
                swim();
            } else {
                if (distance < arr[1]){
                    List<Pair> pairs = map.get(arr[1]);
                    pairs.remove(0);

                    arr[1] = distance;
                    pupValueToMap(distance, new Pair(x, y));
                    sink();
                    System.out.println();
                }
            }
        }

        private void swim() {
            int i = N-1;
            while (i > 1 && less(i/2, i)){
                swap(i, i/2);
                i = i/2;
            }
        }

        private void sink() {
            int i = 1;

            while (i * 2 < N){
                int j = i * 2;
                if (j + 1 < N && less(j, j+1)){
                    j++;
                }
                if (less(i,j)){
                    swap(i, j);
                }
                i = j;
            }
        }

        private void swap(int i, int j) {
            double tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;

        }

        private boolean less(int i, int j) {
            return arr[i] < arr[j];
        }

        private void pupValueToMap(double distance, Pair p) {
            if (map.containsKey(distance)){
                map.get(distance).add(p);
            } else {
                List<Pair> pairs = new ArrayList<>();
                pairs.add(p);
                map.put(distance, pairs);
            }
        }

        private double getDistance(int x, int y) {
            double xRez = Math.pow(-x, 2);
            double yRez = Math.pow(-y, 2);
            return Math.abs(Math.sqrt(xRez + yRez));
        }

        public Pair getMax() {
            double dist = arr[1];
            Pair p = map.get(dist).get(0);
            map.get(dist).remove(0);

            swap(1, --N);
            sink();
            return p;
        }
    }

    private class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
