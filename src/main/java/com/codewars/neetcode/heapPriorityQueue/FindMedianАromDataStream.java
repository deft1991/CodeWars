package com.codewars.neetcode.heapPriorityQueue;

import java.util.PriorityQueue;

/**
 * @author Sergey Golitsyn
 * created on 17.10.2023
 */
public class FindMedianАromDataStream {

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
//        System.out.println(m.findMedian()); // 1
        m.addNum(2);
//        System.out.println(m.findMedian()); // 1.5
        m.addNum(3);
//        System.out.println(m.findMedian()); // 2
        m.addNum(4);
        System.out.println(m.findMedian()); // 2.5
        m.addNum(5);
        System.out.println(m.findMedian()); // 3
        m.addNum(6);
        System.out.println(m.findMedian()); // 3.5
    }

   static class MedianFinder {

        PriorityQueue<Integer> small;
        PriorityQueue<Integer> big;


        public MedianFinder() {
            small = new PriorityQueue<>((a,b) -> b - a);
            big = new PriorityQueue<>();
        }

        public void addNum(int num) {
            small.add(num);

            if(!small.isEmpty() && !big.isEmpty()){
                if (small.peek() > big.peek()){
                    big.add(small.poll());
                }
            }

            while (small.size() - big.size() > 1){
                big.add(small.poll());
            }
            while(big.size() - small.size() > 1){
                small.add(big.poll());
            }

        }

        public double findMedian() {
            int sum = small.size() + big.size();
            if (sum % 2 == 0){
                return (double) (small.peek() + big.peek()) / 2;
            } else {
                return small.size() > big.size() ? small.peek() : big.peek();
            }
        }
    }
}
