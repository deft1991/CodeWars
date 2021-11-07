package com.codewars.leetcode.problems.medium;

/**
 * @author Sergey Golitsyn
 * created on 03.03.2021
 */
public class KthLargestElementInArrayHeap2 {

    public static void main(String[] args) {
        KthLargestElementInArrayHeap2 k = new KthLargestElementInArrayHeap2();

        System.out.println(k.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(k.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        Heap heap = new Heap(k);
        for (int num : nums) {
            heap.insert(num);
        }
        return heap.peek();
    }

    class Heap {
        int[] arr;
        int N;

        Heap(int k) {
            arr = new int[k + 1];
            N = 0;
        }

        public void insert(int val) {
            if (N < arr.length - 1) {
                arr[++N] = val;
                swim(N);
            } else {
                if (arr[1] < val) {
                    arr[1] = val;
                    sink(1);
                }
            }
        }

        private void swim(int n) {
            while (n > 1 && less(n, n / 2)) {
                exch(n / 2, n);
                n = n / 2;
            }
        }

        private void exch(int n, int i) {
            int tmp = arr[n];
            arr[n] = arr[i];
            arr[i] = tmp;
        }

        private boolean less(int n, int i) {
            return arr[n] < arr[i];
        }

        public void remove() {
            exch(1, N--);
            sink(1);
        }

        private void sink(int i) {
            while (i * 2 <= N){
                int child = i * 2;

                if (child < N && !less(child, child + 1)){
                    child ++;
                }

                if (less(i, child)){
                    break;
                }
                exch(i, child);
                i = child;
            }
        }

        public int peek() {
            return arr[1];
        }
    }
}
