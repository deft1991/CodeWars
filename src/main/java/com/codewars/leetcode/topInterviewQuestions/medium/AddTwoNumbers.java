package com.codewars.leetcode.topInterviewQuestions.medium;

import com.codewars.leetcode.handbook.ListNode;

/*
 * Created by sgolitsyn on 8/13/20
 *
 You are given two non-empty linked lists representing two non-negative integers.
 The digits are stored in reverse order and each of their nodes contain a single digit.
 Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

        ListNode l7 = new ListNode(5);
        ListNode l8 = new ListNode(5);


        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(8);
        l9.next = l10;

        ListNode l11 = new ListNode(1);


        ListNode l12 = new ListNode(1);

        ListNode l13 = new ListNode(9);
        ListNode l14 = new ListNode(9);
        l13.next = l14;


        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode = addTwoNumbers.addTwoNumbers(l1, l4);
        System.out.println(listNode);

        listNode = addTwoNumbers.addTwoNumbers(l7, l8);
        System.out.println(listNode);

        listNode = addTwoNumbers.addTwoNumbers(l9, l11);
        System.out.println(listNode);


        listNode = addTwoNumbers.addTwoNumbers(l12, l13);
        System.out.println(listNode);


    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rez = null;
        ListNode rezLast = new ListNode();

        int delim = 0;
        while (l1 != null && l2 != null) {

            int sum = l1.val + l2.val + delim;
            delim = sum / 10;
            sum %= 10;
            ListNode nextNode = new ListNode(sum);
            if (rez == null) {
                rez = nextNode;
                rezLast = rez;
            } else {
                rezLast.next = nextNode;
                rezLast = nextNode;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + delim;
            delim = sum / 10;
            sum %= 10;
            ListNode nextNode = new ListNode(sum);
            if (rez == null) {
                rez = nextNode;
                rezLast = rez;
            } else {
                rezLast.next = nextNode;
                rezLast = nextNode;
            }
            l1 = l1.next;
        }


        while (l2 != null) {
            int sum = l2.val + delim;
            delim = sum / 10;
            sum %= 10;
            ListNode nextNode = new ListNode(sum);
            if (rez == null) {
                rez = nextNode;
                rezLast = rez;
            } else {
                rezLast.next = nextNode;
                rezLast = nextNode;
            }
            l2 = l2.next;
        }

        if (delim != 0) {
            rezLast.next = new ListNode(1);
        }
        return rez;
    }

}
