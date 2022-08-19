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
            current.push(x);
        }

        public int pop() {
            if (!tmp.isEmpty()) {
                return tmp.pop();
            }
            while (!current.isEmpty()) {
                tmp.push(current.pop());
            }
            return tmp.pop();
        }

        public int peek() {
            if (!tmp.isEmpty()) {
                return tmp.peek();
            }
            while (!current.isEmpty()) {
                tmp.push(current.pop());
            }
            return tmp.peek();
        }

        public boolean empty() {
            if (!tmp.isEmpty()) {
                return tmp.isEmpty();
            }
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
            while (!current.isEmpty()) {
                tmp.push(current.pop());
            }
            current.push(x);
            while (!tmp.isEmpty()) {
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
