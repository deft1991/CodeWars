package com.codewars.leetcode.explore.linkedListRepeat;

import com.codewars.leetcode.problems.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 28.11.2021
 */
public class OddEvenLinkedList {

    public static void main(String[] args) {

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode oddHead = null;
        ListNode oddTail = null;
        ListNode evenHead = null;
        ListNode evenTail = null;
        int counter = 0;

        while(head != null) {
            counter += 1;
            if (counter % 2 != 0) {
                if (oddHead == null) {
                    oddHead = head;
                    oddTail = head;

                } else {
                    oddTail.next = head;
                    oddTail = head;
                }
            } else {
                if (evenHead == null) {
                    evenHead = head;
                    evenTail = head;

                } else {
                    evenTail.next = head;
                    evenTail = head;
                }
            }
            head = head.next;
        }

        oddTail.next = evenHead;
        if (evenTail != null){
            evenTail.next = null;
        }
        return oddHead;
    }
}
