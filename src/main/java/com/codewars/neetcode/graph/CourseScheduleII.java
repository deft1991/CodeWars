package com.codewars.neetcode.graph;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 30.10.2023
 */
public class CourseScheduleII {

    public static void main(String[] args) {
        CourseScheduleII c = new CourseScheduleII();
//        System.out.println(
//                Arrays.toString(
//                        c.findOrder(4, new int[][]{
//                                {1, 0},
//                                {2, 0},
//                                {3, 1},
//                                {3, 2}
//                        })));
        System.out.println(
                Arrays.toString(
                        c.findOrder(2, new int[][]{
                                {1, 0},
                        })));
        System.out.println(
                Arrays.toString(
                        c.findOrder(1, new int[][]{
                        })));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] count = new int[numCourses];
        Map<Integer, List<Integer>> adjusted = new HashMap<>();

        for (int[] course : prerequisites){
            List<Integer> child = adjusted.getOrDefault(course[1], new ArrayList<>());
            child.add(course[0]);
            adjusted.put(course[1], child);
            count[course[0]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++){
            if (count[i] == 0){
                q.add(i);
            }
        }
        if (q.isEmpty()){
            return new int[0];
        }

        List<Integer> rez = new ArrayList<>();
        while (!q.isEmpty()){
            int current = q.poll();
            rez.add(current);
            List<Integer> childs = adjusted.get(current);
            if (childs == null){
                continue;
            }
            for (int child : childs){
                count[child]--;
                if (count[child] == 0){
                    q.add(child);
                }
            }
        }
        if (rez.size() != numCourses){
            return new int[0];
        }
        return rez.stream().mapToInt(i -> i).toArray();
    }
}
