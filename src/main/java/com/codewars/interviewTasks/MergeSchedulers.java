package com.codewars.interviewTasks;

/*

I am representing schedules as singly linked lists of characters. So, for example, here is my morning:

'A' -> 'B' -> 'C'

This means that I have three events today, and they will occur in the order A then B then C. No information is given about the absolute time of the event.

Here is your schedule for the morning:

'X' -> 'B' -> 'Z'

Since we both have the character B in our schedules, it means that we have the same event.

Write a function that takes in two schedules and returns a new, merged schedule for the day. In our example, one correctly merged schedule might look like:

'A' -> 'X' -> 'B' -> 'C' -> 'Z'

Note how B only appears once.


1. Node + empty --> return Node
2. if all empty --> empty

3. A B C
   Q W Z D C

   A Q B W Z D C


   i need to save order for each user

   two pointers

   aPointer
   bPointer

   if(bMap.contains aPointer){
    add bPointer to result
   }
   if same add to result and move forward

   Time O(N)
   Space O(N)


*/
/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class MergeSchedulers {
    public static void main(String[] args) {

        MergeSchedulers solution = new MergeSchedulers();
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        a.next = b;
        b.next = c;



        // Q W Z D C
        Node q = new Node('q');
        Node w = new Node('w');
        Node z = new Node('z');
        Node d = new Node('d');
        q.next = w;
        w.next = z;
        z.next = d;
        d.next = c;
        // a -> q -> b -> w -> z ->  d ->  c
        Node rez = solution.mergeSchedules(a, q);
        String s = solution.nodeToString(rez);
        System.out.println("result:" + s);
    }

    public Node mergeSchedules(Node firstSchedule, Node secondSchedule){
        System.out.println("mergeSchedules");
        if(firstSchedule == null){
            return secondSchedule;
        }
        if(secondSchedule == null ){
            return firstSchedule;
        }

        Node result = new Node();
        Node resultHead = result;

        Set<Character> first = new HashSet<>();
        Set<Character> second = new HashSet<>();

        Node firstScheduleTmp = firstSchedule;
        Node secondScheduleTmp = secondSchedule;
        while(firstScheduleTmp != null){
            first.add(firstScheduleTmp.value);
            firstScheduleTmp = firstScheduleTmp.next;
        }

        while(secondScheduleTmp != null){
            second.add(secondScheduleTmp.value);
            secondScheduleTmp = secondScheduleTmp.next;
        }

        Node firstPointer = firstSchedule;
        Node secondPointer = secondSchedule;


        while(firstPointer != null && secondPointer != null){
            if(firstPointer.value == secondPointer.value){

                Node tmp = new Node();
                tmp.value = firstPointer.value;
                result.next = tmp;
                result = tmp;
                firstPointer = firstPointer.next;
                secondPointer = secondPointer.next;
            } else if(second.contains(firstPointer.value)){
                Node tmp = new Node();
                tmp.value = secondPointer.value;
                result.next = tmp;
                result = tmp;
                secondPointer = secondPointer.next;
            } else if(first.contains(secondPointer.value)){
                Node tmp = new Node();
                tmp.value = firstPointer.value;
                result.next = tmp;
                result = tmp;
                firstPointer = firstPointer.next;
            } else {
                Node tmpOne = new Node();
                tmpOne.value = firstPointer.value;
                result.next = tmpOne;
                result = tmpOne;
                firstPointer = firstPointer.next;

                Node tmpTwo = new Node();
                tmpTwo.value = secondPointer.value;
                result.next = tmpTwo;
                result = tmpTwo;
                secondPointer = secondPointer.next;
            }
        }

        while(firstPointer != null){
            Node tmp = new Node();
            tmp.value = firstPointer.value;
            result.next = tmp;
            result = tmp;
            firstPointer = firstPointer.next;
        }

        while(secondPointer != null){
            Node tmp = new Node();
            tmp.value = secondPointer.value;
            result.next = tmp;
            result = tmp;
            secondPointer = secondPointer.next;
        }
        return resultHead.next;
    }

    // a --> b -->  c
    public String nodeToString(Node node){
        StringBuilder sb = new StringBuilder();
        while(node != null && node.next != null){
            sb.append(node.value);
            sb.append(" --> ");
            node = node.next;
        }
        sb.append(node.value);
        return sb.toString();
    }

    static class Node{
        char value;
        Node next;

        public Node(){}
        public Node(char value){
            this.value = value;
        }
    }

}

/*
   i need to save order for each user

   two pointers

   aPointer
   bPointer

   if(bMap.contains aPointer){
    add bPointer to result
   }
   if same add to result and move forward

   Time O(N)
   Space O(N)

   no duplicates
 */

// todo rename to ScheduleNode

