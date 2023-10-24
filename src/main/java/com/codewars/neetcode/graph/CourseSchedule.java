package com.codewars.neetcode.graph;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 24.10.2023
 */
public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule c = new CourseSchedule();

        System.out.println(c.canFinish(2, new int[][]{
                {1,0}
        }));

        System.out.println(c.canFinish(5, new int[][]{
                {1,4},
                {2,4},
                {3,1},
                {3,2},
        }));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0){
            return true;
        }
        Queue<Integer> q = new ArrayDeque<>();
        Map<Integer, List<Integer>> adjustment = new HashMap<>();
        Map<Integer, Integer> childCount = new HashMap<>();

        for(int [] pair : prerequisites){
            int to = pair[0];
            int from = pair[1];
            List<Integer> adjustments = adjustment.getOrDefault(from, new ArrayList<>());
            adjustments.add(to);
            adjustment.put(from, adjustments);

            childCount.put(to, childCount.getOrDefault(to, 0) + 1);
        }

        for (Integer key : adjustment.keySet()){
            if(!childCount.containsKey(key)){
                q.add(key);
            }
        }
        while(!q.isEmpty()){
            numCourses--;
            Integer course = q.poll();
            if (adjustment.get(course) == null){
                continue;
            }
            for (Integer child : adjustment.get(course)){
                childCount.put(child, childCount.get(child) - 1);
                if (childCount.get(child) == 0){
                    q.add(child);
                }
            }
        }
        return numCourses <=1;
    }
}
