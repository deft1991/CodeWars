package com.codewars.leetcode.dataStructure;

import com.codewars.leetcode.handbook.ListNode;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author Sergey Golitsyn
 * created on 19.04.2022
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
//        ListNode dummy = new ListNode();
//        dummy.next = head;
        Stack<Character> stack = new Stack<>();

        ListNode prev = head;

        while(prev != null && prev.next != null){
            if(prev.val == prev.next.val){
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}
