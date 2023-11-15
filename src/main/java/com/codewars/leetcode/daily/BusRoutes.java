package com.codewars.leetcode.daily;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 12.11.2023
 */
public class BusRoutes {

    public static void main(String[] args) {
        BusRoutes b = new BusRoutes();
        System.out.println(b.numBusesToDestination(new int[][]{
                {1,2,7},
                {3,6,7},
        }, 1, 6));
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if  (source == target){
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < routes.length; i++){
            for (int r : routes[i]){
                List<Integer> orDefault = map.getOrDefault(r, new ArrayList<>());
                orDefault.add(i);
                map.put(r, orDefault);
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        for (int r : map.get(source)){
            q.add(r);
            visited.add(r);
        }
        int count = 1;
        while (!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++){
                int curRoute = q.poll();

                // Iterate over the stops in the current route.
                for (int stop : routes[curRoute]){
                    // Return the current count if the target is found.
                    if (stop == target){
                        return count;
                    }
                    // Iterate over the next possible routes from the current stop.
                    for (int next : map.get(stop)){
                        if (!visited.contains(next)){
                            visited.add(next);
                            q.add(next);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
