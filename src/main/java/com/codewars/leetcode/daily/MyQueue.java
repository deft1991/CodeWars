package com.codewars.leetcode.daily;

import java.util.Stack;

/**
 * @author Sergey Golitsyn
 * created on 29.01.2024
 */
public class MyQueue {

    public static void main(String[] args) {
        MyQueue m = new MyQueue();
        m.push(1);
        m.push(2);
        System.out.println(m.peek());;
        System.out.println(m.pop());
        System.out.println(m.empty());;
    }

    private Stack<Integer> a;
    private Stack<Integer> b;

    public MyQueue() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int x) {
        a.add(x);
    }

    public int pop() {
        if(!b.isEmpty()){
            return b.pop();
        }
        while(!a.isEmpty()){
            b.add(a.pop());
        }
        return b.pop();
    }

    public int peek() {
        if(!b.isEmpty()){
            return b.peek();
        }
        while(!a.isEmpty()){
            b.add(a.pop());
        }
        return b.peek();
    }

    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
    }
}
