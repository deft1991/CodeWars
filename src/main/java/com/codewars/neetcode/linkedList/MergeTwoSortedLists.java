package com.codewars.neetcode.linkedList;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 06.01.2023
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        MergeTwoSortedLists m = new MergeTwoSortedLists();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;

        ListNode d = new ListNode(1);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(5);
        d.next = e;
        e.next = f;
        f.next = g;

        ListNode listNode = m.mergeTwoLists(a, d);
        System.out.println();

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }

        ListNode tmp = new ListNode();
        ListNode head = tmp;


        while(list1 != null && list2 != null){
            if (list1.val <= list2.val){
                tmp.next = list1;

                list1 = list1.next;
            } else {
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }

        while (list1 != null){
            tmp.next = list1;
            list1 = list1.next;
            tmp = tmp.next;
        }
        while (list2 != null){
            tmp.next = list2;
            list2 = list2.next;
            tmp = tmp.next;
        }
        return head.next;
    }
}
