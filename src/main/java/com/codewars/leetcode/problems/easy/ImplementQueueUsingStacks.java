package com.codewars.leetcode.problems.easy;

import java.util.Stack;

/**
 * @author Sergey Golitsyn
 * created on 07.08.2022
 */
public class ImplementQueueUsingStacks {

    public static void main(String[] args) {
        MyQueue mq = new MyQueue();
        mq.push(1);
        mq.push(2);
        mq.push(3);
        mq.push(4);
        System.out.println(mq.pop());
        mq.push(5);
        System.out.println(mq.pop());
        System.out.println(mq.pop());
        System.out.println(mq.pop());
        System.out.println(mq.pop());
    }

    static class MyQueue {

        Stack<Integer> current;
        Stack<Integer> tmp;

        public MyQueue() {
            current = new Stack<>();
            tmp = new Stack<>();
        }

        public void push(int x) {
            int size = current.size();

            for (int i = 0; i < size; i ++){
                tmp.push(current.pop());
            }
            current.push(x);
            for (int i = 0; i < size; i++){
                current.push(tmp.pop());
            }
        }

        public int pop() {
            return current.pop();
        }

        public int peek() {
            return current.peek();
        }

        public boolean empty() {
            return current.isEmpty();
        }
    }

    static class MyQueue2 {

        Stack<Integer> current;
        Stack<Integer> tmp;

        public MyQueue2() {
            current = new Stack<>();
            tmp = new Stack<>();
        }

        public void push(int x) {
            int size = current.size();

            for (int i = 0; i < size; i ++){
                tmp.push(current.pop());
            }
            current.push(x);
            for (int i = 0; i < size; i++){
                current.push(tmp.pop());
            }
        }

        public int pop() {
            return current.pop();
        }

        public int peek() {
            return current.peek();
        }

        public boolean empty() {
            return current.isEmpty();
        }
    }
}
