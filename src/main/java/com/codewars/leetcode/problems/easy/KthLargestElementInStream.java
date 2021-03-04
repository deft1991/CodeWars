package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 03.03.2021
 */
public class KthLargestElementInStream {

    public static void main(String[] args) {

        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});

        System.out.println(kthLargest.add(3)); // 4
        System.out.println(kthLargest.add(5)); // 5
        System.out.println(kthLargest.add(10)); // 5
        System.out.println(kthLargest.add(9)); // 8
        System.out.println(kthLargest.add(3)); // 8

        KthLargest kthLargest2 = new KthLargest(2, new int[]{0});
        System.out.println(kthLargest2.add(-1));
        System.out.println(kthLargest2.add(1));
        System.out.println(kthLargest2.add(-2));
        System.out.println(kthLargest2.add(-4));
        System.out.println(kthLargest2.add(3));
    }


    static class KthLargest {
        int k;
        int[] arr;
        int N = 0;

        public KthLargest(int k, int[] arr) {
            this.k = k;
            this.arr = new int[k + 1];
            for (int i = 0; i < arr.length; i++) {
                this.add(arr[i]);
            }
        }

        public int add(int i) {
            if (N < arr.length - 1) {
                arr[++N] = i;
                swim(N);
            } else {
                if (i > arr[1]) {
                    arr[1] = i;
                    sink(1);
                }
            }
            return arr[1];
        }

        private void sink(int n) {
            while (2 * n < arr.length) {
                int j = 2 * n;
                if (j < arr.length - 1 && less(j + 1, j)) {
                    j++;
                }
                if (less(n, j)) {
                    break;
                }
                exch(n, j);
                n = j;
            }
        }


        private void swim(int n) {
            while (n > 1 && !less(n / 2, n)) {
                exch(n / 2, n);
                n = n / 2;
            }
        }

        private void exch(int i, int n) {
            int tmp = arr[i];
            arr[i] = arr[n];
            arr[n] = tmp;
        }

        private boolean less(int i, int n) {
            return arr[i] < arr[n];
        }


    }
}
