package com.codewars.leetcode.problems.medium;

/**
 * @author Sergey Golitsyn
 * created on 04.03.2021
 */
public class KthSmallestElementInSortedMatrix {

    public static void main(String[] args) {
        KthSmallestElementInSortedMatrix k = new KthSmallestElementInSortedMatrix();
        System.out.println(k.kthSmallest(new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        }, 8));
    }

    public int kthSmallest(int[][] matrix, int k) {
        Heap heap = new Heap(k + 1);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                heap.insert(matrix[i][j]);
            }
        }
        return heap.peek();
    }

    class Heap {
        int N = 0;
        int arr[];

        Heap(int length) {
            arr = new int[length];
        }

        void insert(int val) {
            if (N < arr.length - 1) {
                arr[++N] = val;
                swim(N);
            } else {
                if (val < arr[1]) {
                    arr[1] = val;
                    sink(1);
                }
            }
        }

        private void sink(int idx) {
            while (idx * 2 <= N) {
                int j = idx * 2;
                if (j < N && less(j, j + 1)) {
                    j++;
                }

                if (!less(idx, j)) {
                    break;
                }
                exch(idx, j);
                idx = j;
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

        public int peek() {
            return arr[1];
        }
    }
}
