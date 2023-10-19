package com.codewars.faangtalk;

import java.util.Stack;

/**
 * @author Sergey Golitsyn
 * created on 13.09.2023
 */
class MyQueue {

    public static void main(String[] args) {
        MyQueue m = new MyQueue();
        m.push(1);
        m.push(2);
        m.peek();
    }

    private Stack<Integer> first;
    private Stack<Integer> second;

    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        first.add(x);
    }

    public int pop() {
        if(second.isEmpty()){
            while(!first.isEmpty()){
                second.add(first.pop());
            }
        }
        return second.pop();
    }

    public int peek() {
        if(second.isEmpty()){
            while(!first.isEmpty()){
                second.add(first.pop());
            }
        }
        return second.peek();
    }

    public boolean empty() {
        return first.isEmpty() && second.isEmpty();
    }
}
