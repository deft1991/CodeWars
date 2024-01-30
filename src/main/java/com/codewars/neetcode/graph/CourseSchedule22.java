package com.codewars.neetcode.graph;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 30.01.2024
 */
public class CourseSchedule22 {

    public static void main(String[] args) {
        CourseSchedule22 c = new CourseSchedule22();
        System.out.println(Arrays.toString(
                c.findOrder(3, new int[][]{
                        {1, 0},
                        {1, 2},
                        {0, 1},
                })));
        System.out.println(Arrays.toString(
                c.findOrder(1, new int[][]{

                })));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] edges = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int from = pair[0];
            int to = pair[1];

            graph.get(to).add(from);
            edges[from]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] == 0) {
                q.add(i);
            }
        }
        if (q.isEmpty()) {
            return new int[0];
        }
        List<Integer> rez = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        while (!q.isEmpty()) {
            int course = q.poll();
            if (visited.contains(course)) {
                continue;
            }
            rez.add(course);
            visited.add(course);
            List<Integer> depends = graph.get(course);
            for (int d : depends) {
                edges[d]--;
                if (edges[d] == 0) {
                    q.add(d);
                }
            }
        }
        return rez.size() != numCourses ? new int[0] : rez.stream().mapToInt(i -> i).toArray();
    }
}
