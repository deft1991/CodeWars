package com.codewars.leetcode.problems.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 08.02.2021
 */
public class MostStonesRemovedWithSameRowOrColumn {

    public static void main(String[] args) {
        MostStonesRemovedWithSameRowOrColumn m = new MostStonesRemovedWithSameRowOrColumn();
        System.out.println(m.removeStones(new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}}));
    }

    public int removeStones(int[][] stones) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int[] edge: stones){
            if(!isConnected(map, edge[0], edge[1])){
                connect(map, edge[0], edge[1]);
            }
        }
        int size = (int) map.values().stream().distinct().count();

        return stones.length - size;
    }

    private boolean isConnected(Map<Integer, Integer> map, int i, int j){
        return root(map, map.getOrDefault(i, i)) == root(map, map.getOrDefault(j, j));
    }

    private int root(Map<Integer, Integer> map, int i){
        if (map.get(i) == null){
            map.put(i, i);
            return i;
        }
        while(i != map.get(i)) {
            map.put(i, map.get(i));
            i = map.get(i);
        }
        return i;
    }

    private void connect(Map<Integer, Integer> map, int i, int j) {
        int rootI = root(map, i);
        int rootJ = root(map, j);

        map.put(j, rootI);
    }
}
