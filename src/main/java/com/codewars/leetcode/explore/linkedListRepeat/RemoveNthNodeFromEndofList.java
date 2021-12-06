package com.codewars.leetcode.explore.linkedListRepeat;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 24.11.2021
 */
public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode empty = new ListNode();

        empty.next = head;
        ListNode slow = empty;
        ListNode fast = empty;

        for (int i = 0; i < n && fast != null; i++){
            fast = fast.next;
        }

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return empty.next;
    }
}
