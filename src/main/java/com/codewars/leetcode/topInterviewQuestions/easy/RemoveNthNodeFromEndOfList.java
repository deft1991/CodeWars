package com.codewars.leetcode.topInterviewQuestions.easy;

import com.codewars.leetcode.handbook.ListNode;

/*
 * Created by sgolitsyn on 8/17/20
 *
 Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList rem = new RemoveNthNodeFromEndOfList();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;


        ListNode listNode = rem.removeNthFromEnd(l4, 1);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;

        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
