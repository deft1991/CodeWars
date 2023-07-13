package com.codewars.neetcode.heapPriorityQueue;

/**
 * @author Sergey Golitsyn
 * created on 20.02.2023
 */
public class LastStoneWeight {

    public static void main(String[] args) {
        LastStoneWeight l = new LastStoneWeight();
        System.out.println(l.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(l.lastStoneWeight(new int[]{1}));
    }


    /*
    1. create max heap
    2. get max element
    3. swap with the last element
     */
    public int lastStoneWeight(int[] stones) {
        MaxHeap mx = new MaxHeap(stones);
        while (mx.N != 1) {
            if (mx.isLast()){
                return mx.arr[1];
            }
            int y = mx.getMax();
            int x = mx.getMax();

            if (x != y) {
                int rest = y - x;
                mx.add(rest);
            }
        }
        return mx.arr[1];
    }

    private class MaxHeap {

        private int[] arr;
        private int N;

        MaxHeap(int[] arr) {
            this.arr = new int[arr.length + 1];
            N = 1;

            for (int v : arr) {
                add(v);
            }
        }

        public void add(int val) {
            arr[N++] = val;
            swim();
        }

        public int getMax() {
            int max = arr[1];
            arr[1] = arr[--N];
            arr[N] = 0;
            sink();
            return max;
        }

        private void swim() {
            int i = N - 1;
            while (i > 1 && isLess(i / 2, i)) {
                swap(i / 2, i);
                i = i / 2;
            }
        }

        private void sink() {
            int i = 1;
            while (i * 2 < arr.length) {
                int j = i * 2;
                if (j + 1 < arr.length && isLess(j, j + 1)) {
                    j++;
                }

                if (isLess(i, j)) {
                    swap(i, j);
                }
                i = j;
            }
        }

        private boolean isLess(int aIdx, int bIdx) {
            return arr[aIdx] < arr[bIdx];
        }

        private void swap(int aIdx, int bIdx) {
            int tmp = arr[aIdx];
            arr[aIdx] = arr[bIdx];
            arr[bIdx] = tmp;
        }

        private boolean isLast() {
            return N - 1 == 1;
        }
    }
}
