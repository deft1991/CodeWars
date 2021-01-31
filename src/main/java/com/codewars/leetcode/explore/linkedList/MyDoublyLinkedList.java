package com.codewars.leetcode.explore.linkedList;

/**
 * @author Sergey Golitsyn
 * created on 31.01.2021
 */
public class MyDoublyLinkedList {


    Node head;

    class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value){
            this.value = value;
        }

    }

    /** Initialize your data structure here. */
    public MyDoublyLinkedList() {
        head = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(head == null){
            return -1;
        }
        Node cur = head;
        for (int i = 0; i< index; i++){
            if (cur != null){
                cur = cur.next;
            } else {
                return - 1;
            }
        }
        if (cur == null){
            return -1;
        }
        return cur.value;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        if (head != null){
            head.prev = node;
        }
        head = node;

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        if(head == null){
            head = node;
        } else{
            Node cur = head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
            node.next = null;
            node.prev = cur;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == 0){
            addAtHead(val);
            return;
        }
        Node node = new Node(val);

        Node cur = head;
        Node prev = null;
        for (int i = 0; i < index; i++){
            if (cur == null){
                return;
            }
            prev = cur;
            cur = cur.next;

            if(cur == null && i + 1 == index){
                prev.next = node;
                return;
            }
        }
        prev.next = node;
        node.prev = prev;
        node.next = cur;
        cur.prev = node;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (head == null){
            return;
        }
        if(index == 0){
            head = head.next;
            return;
        }
        Node cur = head;
        Node prev = null;
        for (int i = 0; i < index; i++){
            prev = cur;
            cur = cur.next;
        }
        if (cur == null){
            return;
        }
        prev.next = cur.next;
        cur.prev = prev;
        cur = null;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
