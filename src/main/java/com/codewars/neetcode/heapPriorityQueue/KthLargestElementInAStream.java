package com.codewars.neetcode.heapPriorityQueue;

/**
 * @author Sergey Golitsyn
 * created on 15.02.2023
 */
public class KthLargestElementInAStream {

    public static void main(String[] args) {
//        KthLargest k = new KthLargest(3, new int[]{4, 5, 8, 2});
        KthLargest k = new KthLargest(3, new int[]{-4, -5, -8, -2});

        System.out.println(k.add(3)); // 4
        System.out.println(k.add(5)); // 5
        System.out.println(k.add(10)); // 5
        System.out.println(k.add(9)); // 8
        System.out.println(k.add(4)); // 8
    }

    static class KthLargest {

        private final int[] nums;
        private int N;

        public KthLargest(int k, int[] nums) {
            this.N = 1;
            this.nums = new int[k + 1];

            for (int i : nums) {
                add(i);
            }
        }

        public int add(int val) {
            if (N < nums.length) {
                nums[N++] = val;
                swim();
            } else {
                if (val > nums[1]) {
                    nums[1] = val;
                    sink();
                }
            }
            return nums[1];
        }

        private void swim() {
            int cur = N - 1;
            while (cur > 1 && less(cur, cur/2)) {
                swap(cur, cur / 2);
                cur = cur / 2;
            }
        }

        private void sink() {
            int i = 1;
            while (i * 2 < N) {
                int j = i * 2; // right child
                if (j + 1 < N && less(j + 1, j)) {
                    j++;
                }
                if (less(i, j)) {
                    break;
                }
                swap(i, j);
                i = j;
            }
        }

        private void swap(int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        private boolean less(int i, int j) {
            return nums[i] < nums[j];
        }
    }
}
