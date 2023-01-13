package com.codewars.neetcode.linkedList;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 09.01.2023
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers ad = new AddTwoNumbers();
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;

        ListNode d = new ListNode(5);
        ListNode e = new ListNode(6);
        ListNode f = new ListNode(4);
        d.next = e;
        e.next = f;

        ListNode listNode = ad.addTwoNumbers(a, d);
        System.out.println();

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode headH = head;

        int rest = 0;
        while (l1!= null && l2 != null){
            int sum = l1.val + l2.val + rest;

            ListNode n = new ListNode(sum % 10);
            rest = sum/10;

            head.next = n;
            head = head.next;

            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            int sum = l1.val + rest;

            ListNode n = new ListNode(sum % 10);
            rest = sum/10;

            head.next = n;
            head = head.next;
            l1 = l1.next;
        }
        while (l2 != null){
            int sum = l2.val + rest;

            ListNode n = new ListNode(sum % 10);
            rest = sum/10;

            head.next = n;
            head = head.next;
            l2 = l2.next;
        }
        if (rest != 0){
            head.next = new ListNode(rest);

        }
        return headH.next;
    }
}
