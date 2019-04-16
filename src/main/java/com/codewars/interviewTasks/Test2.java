package com.codewars.interviewTasks;

/**
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 4/3/2019
 */
public class Test2 {
  private Node current;

  public static void main(String[] args) {
    Node n1 = new Node();
    n1.value = 1;
    Node n2 = new Node();
    n2.value = 2;
    Node n3 = new Node();
    n3.value = 3;
    Node n4 = new Node();
    n4.value = 4;
    Node n5 = new Node();
    n5.value = 5;
    Queue queue = new Queue();
    queue.put(n1);
    queue.put(n2);
    queue.put(n3);
    queue.put(n4);
    queue.put(n5);

    System.out.println(queue.get());
    System.out.println(queue.get());
    System.out.println(queue.get());
    System.out.println(queue.get());
    System.out.println(queue.get());
  }
}

class Queue {
  private Node current;
  private Node head;

  public void put(Node node) {
    if (head == null) {
      head = node;
      current = node;
    } else {
      current.next = node;
      current = node;
    }
  }

  public int get() {
    if (head != null) {
      Node tmp = head;
      head = head.next;
      return tmp.value;
    }
    return -1;
  }
}

class Node {
  Node next;
  int value;
}
