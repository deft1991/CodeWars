package com.codewars.leetcode.explore.linkedList;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 27.01.2021
 */
public class ReverseLinkedList {

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
        ListNode listNode = reverseList(one);



    }

    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        if (head.next.next == null){
            ListNode middle = head.next;
            middle.next = head;
            head.next = null;

            return middle;
        }

        ListNode first = null;
        ListNode middle = head;
        ListNode last = head.next;

        while (last != null){
            middle.next = first;
            first = middle;
            middle = last;
            last = last.next;
        }
        middle.next = first;
        return middle;
    }
}
