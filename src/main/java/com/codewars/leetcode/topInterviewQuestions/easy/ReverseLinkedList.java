package com.codewars.leetcode.topInterviewQuestions.easy;

import com.codewars.leetcode.handbook.ListNode;

/*
 * Created by sgolitsyn on 8/17/20
 *
 * * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode start = null;
        ListNode current = head;
        ListNode tail = head;

        while (tail != null){
            current = tail;
            tail = tail.next;
            current.next = start;
            start = current;
        }
        return current;
    }
}
