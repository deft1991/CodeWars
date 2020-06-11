package com.codewars.leetcode.handbook;

/*
 * Created by sgolitsyn on 6/11/20
 *
 * Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        if (head == null) {
            return head;
        }
        while (current.next != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        current.next = prev;
        return current;
    }
}
