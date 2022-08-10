package com.codewars.leetcode.problems.easy;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Sergey Golitsyn
 * created on 07.08.2022
 */
public class ImplementStackUsingQueues {

    public static void main(String[] args) {
        MyStack ms = new MyStack();
        MyStack2 ms2 = new MyStack2();
        System.out.println(ms.top());

        ms.push(1);
        ms.push(2);
        ms.push(3);

        ms2.push(1);
        ms2.push(2);
        ms2.push(3);
        System.out.println(ms2.top());
    }


    static class MyStack {

        private Queue<Integer> current;
        private Queue<Integer> tmp;

        public MyStack() {
            current = new ArrayDeque<>();
            tmp = new ArrayDeque<>();
        }

        public void push(int x) {
            current.add(x);
        }

        public int pop() {
            if (current.isEmpty()){
                return -1;
            }
            int size = current.size();
            for (int i = 0; i < size - 1; i ++){
                tmp.add(current.poll());
            }
            int ret = current.poll();
            current = tmp;
            return ret;
        }

        public int top() {
            if (current.isEmpty()){
                return -1;
            }
            int size = current.size();
            for (int i = 0; i < size - 1; i ++){
                tmp.add(current.poll());
            }
            int ret = current.peek();
            tmp.add(current.poll());
            current = tmp;
            return ret;
        }

        public boolean empty() {
            return current.isEmpty();
        }
    }

    static class MyStack2 {

        private Queue<Integer> current;

        public MyStack2() {
            current = new ArrayDeque<>();
        }

        public void push(int x) {
            current.add(x);
            int size = current.size();

            for (int i = 0; i < size-1; i ++){
                current.add(current.poll());
            }
        }

        public int pop() {
            return current.poll();
        }

        public int top() {
           return current.peek();
        }

        public boolean empty() {
            return current.isEmpty();
        }
    }

}
