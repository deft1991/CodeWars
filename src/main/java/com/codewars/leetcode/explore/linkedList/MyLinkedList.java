package com.codewars.leetcode.explore.linkedList;

/**
 * @author Sergey Golitsyn
 * created on 22.01.2021
 */
class MyLinkedList {

    Node head;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (head == null) {
            return -1;
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            if (cur != null) {
                cur = cur.next;
            } else {
                return -1;
            }
        }
        if (cur == null){
            return -1;
        }
        return cur.value;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0){
            addAtHead(val);
            return;
        }
        Node node = new Node(val);

        Node cur = head;
        Node prev = null;
        for (int i = 0; i < index; i++) {
            if (cur == null) {
                return;
            }
            prev = cur;
            cur = cur.next;

            if (cur == null && i + 1 == index) {
                prev.next = node;
                return;
            }
        }
        prev.next = node;
        node.next = cur;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        Node cur = head;
        Node prev = null;
        for (int i = 0; i < index; i++) {
            prev = cur;
            cur = cur.next;
        }
        if (cur == null){
            return;
        }
        prev.next = cur.next;
        cur = null;
    }
    /**
     *
     */

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(2);
        obj.deleteAtIndex(1);
        obj.addAtHead(2);
        obj.addAtHead(7);
        obj.addAtHead(3);
        obj.addAtHead(2);
        obj.addAtHead(5);
        obj.addAtTail(5);
        obj.get(5);
        obj.deleteAtIndex(6);
        obj.deleteAtIndex(4);
    }
}
