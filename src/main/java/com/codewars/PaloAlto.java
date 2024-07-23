package com.codewars;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 08.05.2024
 */
public class PaloAlto {

    /*
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order,
    and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    [1]
    [1]
    [2]
    --
    [1]
    [9]

    [0]
    reminder 1


    Example 1:Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.

    Example 2:
    Input: l1 = [0], l2 = [0]
    Output: [0]
    Example 3:
    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]

    Constraints:
    The number of nodes in each linked list is in the range[1, 100].
    0 <= Node.val <= 9
    It is guaranteed that the list represents a number that does not have leading zeros.


     1. iterate over 2 list
     --> while first != null and second != null
      --> sum values
       --> if value >= 10 --> add reminder
        --> set value as % 10 (9+9) --> 18 % 10 --> 8 (reminder = 1)

        use reminder
        iterate over first list till the end
        iterate over second list till the end

        return result;

        Time Com O(N) -->
        Space Com O(N) --> N the longest list size

     */

    public static void main(String[] args) {
        PaloAlto p = new PaloAlto();

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

        ListNode sum = p.sum(a, d);
        while (sum != null) {
            System.out.print("-->" + sum.val);
            sum = sum.next;
        }
        System.out.println();
    }

    public ListNode sum(ListNode first, ListNode second){
        ListNode head = new ListNode();
        ListNode cur = head;

        int reminder = 0;
        while(first != null && second != null){
            int val = first.val + second.val + reminder;
            reminder = 0;
            if(val >=  10) {
                reminder = val / 10;
                val = val % 10;
            }
            ListNode newNode = new ListNode(val);
            cur.next = newNode;
            cur = newNode;

            first = first.next;
            second = second.next;
        }

        while(first != null){
            int val = first.val + reminder;
            reminder = 0;
            if(val >=  10) {
                reminder = val / 10;
                val = val % 10;
            }
            ListNode newNode = new ListNode(val);
            cur.next = newNode;
            cur = newNode;
            first = first.next;
        }

        while(second != null){
            int val = second.val + reminder;
            reminder = 0;
            if(val >=  10) {
                reminder = val / 10;
                val = val % 10;
            }
            ListNode newNode = new ListNode(val);
            cur.next = newNode;
            cur = newNode;
            second = second.next;
        }

        if (reminder != 0){
            ListNode newNode = new ListNode(reminder);
            cur.next = newNode;
        }

        return head.next;
    }

}
