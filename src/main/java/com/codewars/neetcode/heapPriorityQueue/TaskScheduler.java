package com.codewars.neetcode.heapPriorityQueue;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 05.04.2023
 */
public class TaskScheduler {

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        System.out.print(ts.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2)); // 8
        System.out.print(ts.leastInterval2(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2)); // 8
        System.out.println(ts.leastInterval3(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2)); // 8
        System.out.print(ts.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0)); // 6
        System.out.print(ts.leastInterval2(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0)); // 6
        System.out.println(ts.leastInterval3(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0)); // 6
        System.out.print(ts.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2)); // 16
        System.out.print(ts.leastInterval2(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2)); // 16
        System.out.println(ts.leastInterval3(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2)); // 16
    }


    public int leastInterval(char[] tasks, int n) {
        int count = 0;

        Map<Character, Integer> countdownMap = new HashMap<>();
        Map<Character, Integer> tasksMap = new HashMap<>();

        for (char c : tasks) {
            tasksMap.put(c, tasksMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(tasksMap.entrySet());

        List<Map.Entry<Character, Integer>> temp = new ArrayList<>();
        Map.Entry<Character, Integer> entry = null;
        while (!pq.isEmpty()) {

            while (!pq.isEmpty() && entry == null) {
                entry = pq.poll();
                if (entry.getValue() > 0
                        && countdownMap.containsKey(entry.getKey())
                        && countdownMap.get(entry.getKey()) > 0) {
                    temp.add(entry);
                    entry = null;
                }
            }


            countdownMap.replaceAll((k, v) -> v - 1);
            count++;

            if (!temp.isEmpty()) {
                pq.addAll(temp);
                temp.clear();
            }
            if (entry == null) {
                System.out.print("idle -->");
                continue;
            }

            System.out.print(entry.getKey() + "-->");
            if (entry.getValue() - 1 != 0) {
                entry.setValue(entry.getValue() - 1);
                pq.add(entry);
                countdownMap.put(entry.getKey(), n);
            }
            entry = null;
            // still on countdown
        }
        return count;
    }

    public int leastInterval2(char[] tasks, int n) {
        int count = 0;

        Map<Character, Integer> tasksMap = new HashMap<>();

        for (char c : tasks) {
            tasksMap.put(c, tasksMap.getOrDefault(c, 0) + 1);
        }


        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Queue<Pair> q = new ArrayDeque<>();

        pq.addAll(tasksMap.values());

        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                Integer poll = pq.poll();
                poll--;
                if (poll > 0) {
                    Pair p = new Pair(poll, time + n);
                    q.add(p);
                }
            }

            if (!q.isEmpty() && q.peek().time == time) {
                pq.add(q.poll().curVal);
            }


            count++;
        }

        return count;
    }

    class Pair {
        int curVal;
        int time;

        Pair(int val, int time) {
            curVal = val;
            this.time = time;
        }
    }


    public int leastInterval3(char[] tasks, int n) {

        Map<Character, Integer> map = new HashMap<>();

        for (char t : tasks) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(map.values());

        Queue<Pair> q = new ArrayDeque<>();
        int time = 0;
        int count = 0;
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;
            while (!q.isEmpty() && q.peek().time <= time) {
                pq.add(q.poll().curVal);
            }
            if (!pq.isEmpty()) {
                int poll = pq.poll();
                poll--;
                if (poll > 0) {
                    q.add(new Pair(poll, time + n + 1));
                }
            }

            count++;
        }
        return count;
    }

}
