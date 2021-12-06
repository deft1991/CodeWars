package com.codewars.leetcode.explore.linkedListRepeat;

import com.codewars.leetcode.handbook.ListNode;

/**
 * @author Sergey Golitsyn
 * created on 03.12.2021
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aEnd = headA;
        ListNode bEnd = headB;
        int aLength = 1;
        int bLength = 1;

        while (aEnd != null){
            aEnd = aEnd.next;
            aLength++;
        }

        while (bEnd != null){
            bEnd = bEnd.next;
            bLength++;
        }

        if (aEnd != bEnd) {
            return null;
        }

        aEnd = headA;
        bEnd = headB;
        int shift = 0;
        if (aLength > bLength) {
            shift = aLength - bLength;
            while (shift > 0){
                aEnd = aEnd.next;
                shift --;
            }
        } else if (bLength > aLength) {
            shift = bLength - aLength;
            while (shift > 0){
                bEnd = bEnd.next;
                shift --;
            }
        }

        while(aEnd != null) {
            if (aEnd == bEnd){
                return aEnd;
            }
            aEnd = aEnd.next;
            bEnd = bEnd.next;
        }

        return null;
    }
}
