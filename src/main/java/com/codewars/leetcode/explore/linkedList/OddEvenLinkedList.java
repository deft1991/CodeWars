package com.codewars.leetcode.explore.linkedList;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 28.01.2021
 */
public class OddEvenLinkedList {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        ListNode three = new ListNode(3);
        two.next = three;
        ListNode four = new ListNode(4);
        three.next = four;
        ListNode five = new ListNode(5);
        four.next = five;
//        ListNode six = new ListNode(6);
//        five.next = six;
//        ListNode seven = new ListNode(7);
//        six.next = seven;
//        ListNode eight = new ListNode(8);
//        seven.next = eight;
//        eight.next = three;
        ListNode listNode = oddEvenList(one);

    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = null, oddHead = null;
        ListNode even = null, evenHead = null;
        int counter = 1;
        while (head != null) {
            if (counter % 2 == 0) {
                if (evenHead == null) {
                    evenHead = head;
                } else {
                    even.next = head;
                }
                even = head;
            } else {
                if (oddHead == null) {
                    oddHead = head;
                } else {
                    odd.next = head;
                }
                odd = head;
            }
            counter++;
            head = head.next;
        }

        if (evenHead != null) {
            even.next = null;
            odd.next = evenHead;
        }
        return oddHead;
    }
}
