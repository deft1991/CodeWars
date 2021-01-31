package com.codewars.leetcode.explore.linkedList;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 29.01.2021
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        ListNode three = new ListNode(1);
        two.next = three;
//        ListNode four = new ListNode(3);
//        three.next = four;
//        ListNode five = new ListNode(2);
//        four.next = five;
//        ListNode six = new ListNode(11);
//        five.next = six;

        System.out.println(isPalindrome(one));

    }

    public static boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }
        if (head.next != null && head.next.next == null) {
            return head.val == head.next.val;
        }

        ListNode fast = head;

        ListNode reverseFirst = null;
        ListNode reverseMiddle = head;
        ListNode reverseLast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            reverseMiddle.next = reverseFirst;
            reverseFirst = reverseMiddle;
            reverseMiddle = reverseLast;
            reverseLast = reverseLast.next;

            if (fast!= null && fast.next == null){
                reverseMiddle = reverseMiddle.next;
                break;
            }
        }
        while (reverseFirst != null){
            if (reverseFirst.val != reverseMiddle.val){
                return false;
            } else {
                reverseFirst = reverseFirst.next;
                reverseMiddle = reverseMiddle.next;
            }
        }
        return true;
    }

}
