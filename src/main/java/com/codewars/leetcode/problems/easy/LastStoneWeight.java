package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 03.03.2021
 */
public class LastStoneWeight {

    public static void main(String[] args) {
        LastStoneWeight l = new LastStoneWeight();
//        System.out.println(l.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(l.lastStoneWeight(new int[]{1,2,3}));
        System.out.println(l.lastStoneWeight(new int[]{2,2}));
        System.out.println(l.lastStoneWeight(new int[]{2,3, 3}));
    }

    public int lastStoneWeight(int[] stones) {
        Heap heap = new Heap(stones.length + 1);

        for (int stone : stones) {
            heap.insert(stone);
        }

        while (true) {
            if (heap.N == 0){
                return 0;
            } else if (heap.N == 1) {
                return heap.removeMax();
            } else {
                int first = heap.removeMax();
                int second = heap.removeMax();
                if (first == second) {

                } else {
                    heap.insert(Math.abs(first - second));
                }
            }
        }
    }

    class Heap {
        int N = 0;
        int arr[];

        Heap(int length) {
            arr = new int[length];
        }

        public void insert(int val) {
            if (N < arr.length) {
                arr[++N] = val;
                swim(N);
            }
        }

        private void swim(int idx) {
            while (idx > 1 && less(idx / 2, idx)) {
                exch(idx / 2, idx);
                idx = idx / 2;
            }
        }

        private void exch(int a, int b) {
            int tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }

        private boolean less(int a, int b) {
            return arr[a] < arr[b];
        }

        public int removeMax() {
            int max = arr[1];
            exch(1, N--);
            sink(1);
            return max;
        }

        private void sink(int i) {
            while (i * 2 <= N) {
                int j = i * 2;
                while (j < N && less(j, j + 1)) {
                    j++;
                }
                if (less(j, i)) {
                    break;
                }
                exch(j, i);
                i = j;
            }
        }
    }
}
