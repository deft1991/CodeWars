package com.codewars.neetcode.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 14.01.2023
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache l = new LRUCache(2);
        l.put(1,1);
        l.put(2,2);
        System.out.println(l.get(1));; // 1
        System.out.println(l.get(3));; // -1
        l.put(3,3);
        System.out.println(l.get(1));; //1
        System.out.println( l.get(2));; // -1
        l.put(4,4);
        System.out.println(l.get(4));; //4
        System.out.println();
    }


    DoubleNode head, tail;
    Map<Integer, DoubleNode> map;
    int capacity, count;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        count = 0;
        head = new DoubleNode();
        tail = new DoubleNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            DoubleNode node = map.get(key);
            removeNode(node);
            addNode(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            DoubleNode node = map.get(key);
            node.val = value;
            removeNode(node);
            addNode(node);
        } else {
            DoubleNode node = new DoubleNode();
            node.key = key;
            node.val = value;
            map.put(key, node);
            addNode(node);
            count++;
            if (count > capacity){
                int removeKey = removeLast();
                map.remove(removeKey);
            }
        }
    }

    private void addNode(DoubleNode node){
        DoubleNode next = head.next;

        head.next = node;
        node.prev = head;

        next.prev = node;
        node.next = next;
    }

    private void removeNode(DoubleNode node){
        DoubleNode prev = node.prev;
        DoubleNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private int removeLast(){
        DoubleNode forRemove = tail.prev;
        DoubleNode prev = forRemove.prev;
        prev.next = tail;
        tail.prev = prev;
        return forRemove.key;
    }



    private class DoubleNode {
        DoubleNode prev, next;
        int key;
        int val;

    }
}
