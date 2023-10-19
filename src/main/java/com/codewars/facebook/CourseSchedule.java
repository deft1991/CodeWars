package com.codewars.facebook;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 28.08.2023
 */
public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule c = new CourseSchedule();
        System.out.println(c.canFinish(2, new int[][]{{1,0}, {0,1}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] arr : prerequisites){
            map.get(arr[1]).add(arr[0]);
            indegree[arr[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            if (indegree[entry.getKey()] == 0) {
                queue.add(entry.getKey());
            }
        }
        int count = 0;
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            count ++;
            for(int link : map.get(poll)){
                indegree[link] --;

                if (indegree[link] == 0){
                    queue.add(link);
                }
            }
        }

        return count == numCourses;
    }
}
