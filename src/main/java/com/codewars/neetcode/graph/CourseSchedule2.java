package com.codewars.neetcode.graph;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 17.01.2024
 */
public class CourseSchedule2 {

    public static void main(String[] args) {
        CourseSchedule2 c = new CourseSchedule2();
        System.out.println(c.canFinish(5, new int[][]{
                {1, 4},
                {2, 4},
                {3, 1},
                {3, 2},

        }));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0){
            return true;
        }
        Map<Integer, Integer> courseInCount = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++){
            graph.put(i, new ArrayList<>());
            courseInCount.put(i, 0);
        }


        for(int[] course : prerequisites){
            int to = course[0];
            int from = course[1];
            courseInCount.put(to, courseInCount.get(to) + 1); // put course with dependence

            List<Integer> list = graph.get(from);
            list.add(to);
            graph.put(from, list);
        }
        Queue<Integer> q = new ArrayDeque<>();

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : courseInCount.entrySet()){
            if (entry.getValue() == 0){
                q.add(entry.getKey());
            }
        }

        while(!q.isEmpty()){
            count++;
            Integer course = q.poll();

            List<Integer> depends = graph.get(course);

            for (Integer depend : depends) {
                Integer dependCount = courseInCount.get(depend);
                if (dependCount - 1 == 0) {
                    q.add(depend);
                } else {
                    courseInCount.put(depend, dependCount - 1);
                }
            }
        }

        return numCourses == count;
    }
}
