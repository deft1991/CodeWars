package com.codewars.leetcode.explore.linkedListRepeat;


import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 30.11.2021
 */
public class AddTwoNumbers {
    ListNode cur;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        int lengthOne = getLength(l1);
        int lengthTwo = getLength(l2);

        if (lengthOne > lengthTwo) {
            int rest = lengthOne - lengthTwo;
            l1 = fillNullNode(l1, rest);
        } else if (lengthTwo > lengthOne) {
            int rest = lengthTwo - lengthOne;
            l2 = fillNullNode(l2, rest);
        }

        addNumbers(l1, l2);
        return cur;
    }

    private int getLength(ListNode l1) {
        int length = 0;

        while(l1 != null){
            length++;
            l1 = l1.next;
        }
        return length;
    }

    private ListNode fillNullNode(ListNode l1, int length){
        for (int i = 0; i < length; i ++){
            ListNode tmp = new ListNode(0);
            tmp.next = l1;
            l1 = tmp;
        }
        return l1;
    }

    private int addNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return 0;
        }
        int tmp = addNumbers(l1.next, l2.next);

        int rez = tmp + l1.val + l2.val;

        ListNode node = new ListNode();
        if (rez == 10){
            node.val = 0;
            node.next = cur;
            cur = node;
            return 1;
        }else if(rez > 10) {
            int rest = rez % 10;
            node.val = rez/10;
            node.next = cur;
            cur = node;
            return rest;
        } else {
            node.val = rez;
            node.next = cur;
            cur = node;
            return 0;
        }
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode rezNodeHead = new ListNode();
        ListNode rezNode = rezNodeHead;
        int rest = 0;
        while (l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int rez = rest + val1 + val2;
            ListNode tmp = new ListNode();
            if (rez == 10) {
                tmp.val = 0;
                rezNode.next = tmp;
                rezNode = tmp;
                rest = 1;
            } else if (rez > 10) {
                int val = rez % 10;
                rest = rez / 10;
                tmp.val = val;
                rezNode.next = tmp;
                rezNode = tmp;
            } else {
                tmp.val = rez;
                rezNode.next = tmp;
                rezNode = tmp;
                rest = 0;
            }
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        if (rest != 0) {
            ListNode tmp = new ListNode();
            tmp.val = rest;
            rezNode.next = tmp;
        }
        return rezNodeHead.next;
    }

}
