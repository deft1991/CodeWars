package com.codewars.leetcode.explore.linkedListRepeat;


import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 29.11.2021
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode empty = new ListNode();
        ListNode emptyHead = empty;

        while(list1 != null && list2 != null) {
            if(list1.val > list2.val) {
                empty.next = list2;
                list2 = list2.next;
                empty = empty.next;
            } else {
                empty.next = list1;
                list1 = list1.next;
                empty = empty.next;
            }
        }

        while (list1 != null) {
            empty.next = list1;
            list1 = list1.next;
            empty = empty.next;
        }
        while (list2 != null) {
            empty.next = list2;
            list2 = list2.next;
            empty = empty.next;
        }
        return emptyHead.next;
    }
}
