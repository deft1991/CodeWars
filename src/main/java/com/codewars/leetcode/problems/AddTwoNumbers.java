package com.codewars.leetcode.problems;

/*
 * Created by sgolitsyn on 3/30/20
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 * Example:

 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

//        ListNode q = new ListNode(2);
//        ListNode w = new ListNode(4);
//        ListNode e = new ListNode(3);
//        q.next = w;
//        w.next = e;
//        ListNode a = new ListNode(5);
//        ListNode s = new ListNode(6);
//        ListNode d = new ListNode(4);
//        a.next = s;
//        s.next = d;
//
//        System.out.println(addTwoNumbers.addTwoNumbers(q,a).val);

        ListNode z = new ListNode(9);
        ListNode x = new ListNode(8);
        z.next = x;
        ListNode c = new ListNode(1);
        System.out.println(addTwoNumbers.addTwoNumbers(z,c));
    }

    /*
    1234 + 123
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        int carry = 0;
        while (l1 != null || l2 != null){
            int a = (l1 != null) ? l1.val : 0;
            int b = (l2 != null) ? l2.val : 0;

            int sum = a + b + carry;
            int val = sum % 10;
            carry = sum / 10;
            current.next = new ListNode(val);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0){
            current.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
