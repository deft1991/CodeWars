package com.codewars.leetcode.problems.easy;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 11.08.2022
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode head = new ListNode(-9);
        ListNode a = new ListNode(3);
//        ListNode b = new ListNode(4);
//        ListNode c = new ListNode(4);
//        ListNode d = new ListNode(5);
//        ListNode e = new ListNode(6);
        head.next = a;
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;

        ListNode head2 = new ListNode(5);
        ListNode q = new ListNode(7);
//        ListNode w = new ListNode(4);
        head2.next = q;
//        q.next = w;

        System.out.println(mergeTwoLists(head, head2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode dummy = new ListNode();
        ListNode dummyHead = dummy;

        while(list1 != null && list2 != null){
            if (list1.val < list2.val){
                dummy.next = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        while(list1 != null){
            dummy.next = list1;
            dummy = dummy.next;
            list1 = list1.next;
        }
        while(list2 != null){
            dummy.next = list2;
            dummy = dummy.next;
            list2 = list2.next;
        }
        return dummyHead.next;
    }
}
