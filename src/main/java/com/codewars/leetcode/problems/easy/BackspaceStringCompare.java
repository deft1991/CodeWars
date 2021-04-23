package com.codewars.leetcode.problems.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Sergey Golitsyn
 * created on 20.04.2021
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {
        BackspaceStringCompare b = new BackspaceStringCompare();

        System.out.println(b.backspaceCompare("y#fo##f", "y#f#o##f"));
    }

    public boolean backspaceCompare(String s, String t) {
        Deque<Character> dequeA = new ArrayDeque<>();
        Deque<Character> dequeB = new ArrayDeque<>();

        fillStack(s, dequeA);
        fillStack(t, dequeB);
        if (dequeA.size() != dequeB.size()) {
            return false;
        }

        while (!dequeA.isEmpty()) {
            if (dequeA.pop() != dequeB.pop()) {
                return false;
            }

        }
        return true;
    }

    private void fillStack(String s, Deque<Character> dequeA) {
        for (char c : s.toCharArray()) {
            if ('#' == c) {
                if (!dequeA.isEmpty()) {
                    dequeA.pop();
                }
            } else {
                dequeA.push(c);
            }
        }
    }
}
