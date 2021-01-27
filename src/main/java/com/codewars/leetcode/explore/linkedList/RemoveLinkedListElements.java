package com.codewars.leetcode.explore.linkedList;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 27.01.2021
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        ListNode three = new ListNode(2);
        two.next = three;
        ListNode four = new ListNode(4);
        three.next = four;
        ListNode five = new ListNode(2);
        four.next = five;
        ListNode listNode = removeElements(one, 2);
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.next == null && head.val == val) {
            return null;
        }

        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode slow = null;
        ListNode fast = head;

        while (fast != null) {
            if (fast.val == val) {
                slow.next = fast.next;
            } else {
                slow = fast;
            }
            fast = fast.next;
        }
        return head;
    }
}
