package com.codewars.leetcode.daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 22.01.2024
 */
public class FindCenterStarGraph {

    public static void main(String[] args) {
        FindCenterStarGraph f = new FindCenterStarGraph();
        System.out.println(f.findCenter(new int[][]{
                {1,2},
                {2,3},
                {4,2},
        }));
        System.out.println(f.findCenter(new int[][]{
                {1,2},
                {5,1},
                {1,3},
                {1,4},
        }));
    }

    public int findCenter(int[][] edges) {
        Map<Integer, Integer> edgesMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int[] pair : edges){
            int from = pair[0];
            int to = pair[1];
            set.add(from);
            set.add(to);

            edgesMap.put(from, edgesMap.getOrDefault(from, 0) + 1);
            edgesMap.put(to, edgesMap.getOrDefault(to, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : edgesMap.entrySet()){
            if(entry.getValue() == set.size() - 1){
                return entry.getKey();
            }
        }
        return -1;
    }
}
