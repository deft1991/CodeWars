package com.codewars.neetcode.heapPriorityQueue;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Sergey Golitsyn
 * created on 13.10.2023
 */
public class TaskScheduler1 {

    public static void main(String[] args) {
        TaskScheduler1 t = new TaskScheduler1();
//        System.out.println(t.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
//        System.out.println(t.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0));
        System.out.println(t.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
    }

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        int[] chars = new int[26];

        for (char c : tasks) {
            chars[c - 'A']++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.val, a.val));
        for (int i : chars) {
            if (i != 0) {
                Pair p = new Pair();
                p.val = i;
                pq.add(p);
            }
        }
        Queue<Pair> q = new ArrayDeque<>();
        int time = 0;
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;
            if (!pq.isEmpty()) {
                Pair poll = pq.poll();
                poll.val--;
                poll.time = time + n;
                if (poll.val > 0) {
                    q.add(poll);
                }
            }
            if (!q.isEmpty() && q.peek().time <= time) {
                pq.add(q.poll());
            }
        }
        return time;
    }

    class Pair {
        int val;
        int time;
    }
}
