package com.codewars.facebook;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 17.08.2023
 *
 * https://leetcode.com/problems/odd-even-linked-list/
 */
public class OddEvenLinkedList {

    public static void main(String[] args) {
        OddEvenLinkedList o = new OddEvenLinkedList();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        o.oddEvenList(a);
        System.out.println();

    }

    public ListNode oddEvenList(ListNode head) {

        ListNode oddHead = new ListNode();
        ListNode oddEnd = oddHead;

        ListNode evenHead = new ListNode();
        ListNode evenEnd = evenHead;

        int counter = 1;
        while (head != null) {
            if (counter % 2 == 0) {
                evenEnd.next = head;
                evenEnd = evenEnd.next;
            } else {
                oddEnd.next = head;
                oddEnd = oddEnd.next;
            }
            counter++;
            head = head.next;
        }
        evenEnd.next = null;
        oddEnd.next = evenHead.next;

        return oddHead.next;
    }
}
