package com.codewars.leetcode.daily;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 20.03.2024
 */
public class MergeBetweenLinkedLists {

    public static void main(String[] args) {
        ListNode a = new ListNode(10);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(13);
        ListNode d = new ListNode(6);
        ListNode e = new ListNode(9);
        ListNode f = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        ListNode x = new ListNode(1000000);
        ListNode y = new ListNode(1000001);
        ListNode z = new ListNode(1000002);
        x.next = y;
        y.next = z;

        MergeBetweenLinkedLists m = new MergeBetweenLinkedLists();

        ListNode result = m.mergeInBetween(a, 3, 4, x);
        System.out.println(result.val);
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode();
        dummy.next = list1;

        ListNode start = null;
        for (int i = 0; i < b; i++) {
            if (i == a - 1) {
                start = list1;
            }
            list1 = list1.next;
        }
        start.next = list2;

        while (list2.next != null) {
            list2 = list2.next;
        }

        list2.next = list1.next;

        return dummy.next;
    }
}
