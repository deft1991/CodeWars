package com.codewars.neetcode.heapPriorityQueue;

/**
 * @author Sergey Golitsyn
 * created on 23.02.2023
 */
public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        KthLargestElementInAnArray k = new KthLargestElementInAnArray();
        System.out.println(k.findKthLargest(new int[]{3,2,1,5,6,4}, 2)); // 5
        System.out.println(k.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4)); // 4
        System.out.println(k.findKthLargest(new int[]{2, 1}, 2)); // 4
    }

    public int findKthLargest(int[] nums, int k) {
        Heap heap = new Heap(k);
        heap.fill(nums);
        return heap.peek();
    }

    private class Heap{
        private int[] arr;
        private int N;

        Heap(int length){
            arr = new int[length + 1];
            N = 1;
        }

        public void fill(int[] nums){
            for (int i : nums){
                add(i);
            }
        }

        public void add(int val){
            if (N < arr.length){
                arr[N++] = val;
                swim();
            } else {
                if (val > arr[1]){
                    arr[1] = val;
                    sink();
                }
            }
        }

        public int peek(){
            return arr[1];
        }


        private void sink() {
            int i = 1;
            while(i * 2 < N){
                int j = i * 2;
                if (j + 1 < N && less(j+1, j)){
                    j++;
                }
                if (less(j, i)){
                    swap(i,j);
                }
                i = j;
            }
        }

        private void swim() {
            int i = N-1;
            while (i / 2 > 0 && less(i, i/2)){
                swap(i, i/2);
                i = i/2;
            }
        }

        private void swap(int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        private boolean less(int i, int j) {
            return arr[i] < arr[j];
        }
    }
}
