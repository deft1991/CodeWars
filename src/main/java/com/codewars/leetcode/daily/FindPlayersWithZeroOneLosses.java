package com.codewars.leetcode.daily;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 15.01.2024
 */
public class FindPlayersWithZeroOneLosses {

    public static void main(String[] args) {
        FindPlayersWithZeroOneLosses f = new FindPlayersWithZeroOneLosses();
        List<List<Integer>> winners = f.findWinners(new int[][]{
                {1, 3},
                {2, 3},
                {3, 6},
                {5, 6},
                {5, 7},
                {4, 5},
                {4, 8},
                {4, 9},
                {10, 4},
                {10, 9}
        });
        System.out.println(Arrays.toString(winners.get(0).toArray()));
        System.out.println(Arrays.toString(winners.get(1).toArray()));
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> players = new HashSet<>();
        Map<Integer, Integer> looser = new HashMap<>();
        for (int[] match : matches) {
            int win = match[0];
            int loose = match[1];

            players.add(win);
            looser.put(loose, looser.getOrDefault(loose, 0) + 1);
        }
        List<List<Integer>> rez = new ArrayList<>();
        List<Integer> win = new ArrayList<>();
        List<Integer> loose = new ArrayList<>();
        for(int p : players){
            if(!looser.containsKey(p)){
                win.add(p);
            }
        }
        for(Map.Entry<Integer, Integer> entry : looser.entrySet()){
            if(entry.getValue() == 1){
                loose.add(entry.getKey());
            }
        }
        rez.add(win);
        rez.add(loose);
        return rez;
    }
}
