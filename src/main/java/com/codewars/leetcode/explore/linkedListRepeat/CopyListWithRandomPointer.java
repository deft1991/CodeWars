package com.codewars.leetcode.explore.linkedListRepeat;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 03.12.2021
 */
public class CopyListWithRandomPointer {

    public static void main(String[] args) {
        Node head = new Node(7);
        Node a = new Node(13);
        Node b = new Node(11);
        Node c = new Node(10);
        Node d = new Node(1);

        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;

        head.random = null;
        a.random = head;
        b.random = d;
        c.random = b;
        d.random = a;

        CopyListWithRandomPointer cl = new CopyListWithRandomPointer();
        Node rez = cl.copyRandomList(head);
        System.out.println(rez);
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node copy = new Node(0);
        Node headCopy = copy;

        Map<Node, Node> map = new HashMap<>();

        Node headTmp = head;
        while(headTmp != null) {
            Node tmp = new Node(headTmp.val);
            copy.next = tmp;
            copy = tmp;
            map.put(headTmp, tmp);
            headTmp = headTmp.next;
        }

        headTmp = head;
        copy = headCopy.next;
        while(headTmp != null) {
            if (headTmp.random != null){
               Node rndCopy =  map.get(headTmp.random);
               copy.random = rndCopy;
            }
            headTmp = headTmp.next;
            copy = copy.next;
        }
        return headCopy.next;
    }
}
