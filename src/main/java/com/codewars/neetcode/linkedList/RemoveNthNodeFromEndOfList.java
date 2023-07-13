package com.codewars.neetcode.linkedList;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 06.01.2023
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList r = new RemoveNthNodeFromEndOfList();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode listNode = r.removeNthFromEnd(a, 3);
        System.out.println();


    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = new ListNode();
        tmp.next = head;
        ListNode slow = tmp;
        ListNode fast = tmp;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        ListNode prev = tmp;
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if (slow != null) {
            prev.next = slow.next;
        }

        return tmp.next;
    }
}
