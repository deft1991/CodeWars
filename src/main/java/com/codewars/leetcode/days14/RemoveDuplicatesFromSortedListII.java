package com.codewars.leetcode.days14;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 04.03.2022
 */
public class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

//        r.deleteDuplicates(a);

        ListNode a1 = new ListNode(1);
        ListNode b2 = new ListNode(2);
        a1.next = b2;
        r.deleteDuplicates(a1);

        ListNode a3 = new ListNode(3);
        r.deleteDuplicates(a3);

        ListNode a4 = new ListNode(1);
        ListNode b4 = new ListNode(1);
        ListNode c4 = new ListNode(1);
        ListNode d4 = new ListNode(1);
        ListNode e4 = new ListNode(1);
        ListNode f4 = new ListNode(1);
        ListNode g4 = new ListNode(1);

        a4.next = b4;
        b4.next = c4;
        c4.next = d4;
        d4.next = e4;
        e4.next = f4;
        f4.next = g4;

        r.deleteDuplicates(a4);

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tmp = new ListNode(-999);
        tmp.next = head;

        ListNode slow = tmp;
        ListNode fast = tmp.next;
        ListNode prev = null;
        while (fast != null) {

            if (slow.val == fast.val) {
                while (fast != null && slow.val == fast.val) {
                    fast = fast.next;
                }
                prev.next = fast;
                slow = prev.next;
                if (fast == null) {
                    return tmp.next;
                } else {
                    fast = fast.next;
                }
            } else {
                prev = slow;
                slow = fast;
                fast = fast.next;
            }
        }
        return tmp.next;
    }
}
