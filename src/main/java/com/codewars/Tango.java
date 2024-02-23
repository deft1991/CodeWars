package com.codewars;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Sergey Golitsyn
 * created on 02.02.2024
 */
public class Tango {
    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.add("1", "A");
        lru.add("2", "B");
        lru.add("3", "C");

        System.out.println(lru.toString());

        System.out.println(lru.getLast());

        System.out.println(lru.toString());

    }

    /*
    Implement LRU cache

    add(String val, String val)
    update(String val, String val)
    remove(String key)
    getLast(); // least r used
    getFirst();

    all operations in O(1)

    class Node, next, prev, String value

    * = 1 = 2 = 3 = *

    map<key, Node> [1-Node, 2-node, 3-node]

    add(String val, String val) --> add value into map, add it to the head
     --> get from map and move to the head

     remove(String key)
      --> remove from the map
      --> remove from the list --> cur.prev <=> cur.next

      getLast()
       --> tail.next --> move to the head

       getFirst()
       --> head.prev

     */


    static class LRU {

        private final Map<String, Node> nodes;
        private final Node tail;
        private final Node head;

        int cap;
        int currentLength;

        LRU(int cap) {
            this.cap = cap;
            currentLength = 0;
            nodes = new HashMap<>();
            tail = new Node();
            head = new Node();

            tail.next = head;
            head.prev = tail;
        }

        public void add(String key, String value) {
            if (nodes.containsKey(key)) {
                Node cur = nodes.get(key);

                cur.prev.next = cur.next; // * - 2 - *
                moveToHead(cur);
            } else {
                if (currentLength == cap) {
                    remove(tail.next.value);
                }
                Node cur = new Node(value);
                nodes.put(key, cur);
                moveToHead(cur);
                currentLength++;
            }
        }

        private void moveToHead(Node cur) {
            Node prev = head.prev;
            prev.next = cur;
            cur.prev = prev;

            head.prev = cur;
            cur.next = head;
        }

        public void remove(String key) {
            if (nodes.containsKey(key)) {
                Node cur = nodes.remove(key);

                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                currentLength--;
            }
        }

        public String getLast() {
            Node last = tail.next;

            tail.next = last.next;
            last.prev = tail;

            head.prev.next = last;
            last.prev = head.prev;

            last.next = head;
            head.prev = last;

            return last.value;
        }

        public String getFirst() {
            return head.prev.value;
        }

        public String toString(){
            Node cur = tail.next;
            StringBuilder sb = new StringBuilder();
            while(cur != head){
                sb.append(cur.value);
                sb.append(" --> ");
                cur = cur.next;
            }
            return sb.toString();
        }

    }

    static class Node {
        Node prev;
        Node next;

        String value;

        Node() {
        }

        Node(String value) {
            this.value = value;
        }
    }

}
