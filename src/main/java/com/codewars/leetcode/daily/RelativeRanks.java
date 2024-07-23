package com.codewars.leetcode.daily;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 08.05.2024
 */
public class RelativeRanks {

    public static void main(String[] args) {
        RelativeRanks r = new RelativeRanks();
        System.out.println(Arrays.toString(r.findRelativeRanks(new int[]{5,4,3,2,1})));
    }

    public String[] findRelativeRanks(int[] score) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> score[b] - score[a]);

        for (int i = 0; i < score.length; i++){
            pq.offer(i);
        }

        String first = "Gold Medal";
        String second = "Silver Medal";
        String third = "Bronze Medal";

        int pos = 0;
        String[] rez = new String[score.length];
        while (!pq.isEmpty()){
            int idx = pq.poll();
            if(pos == 0){
                rez[idx] = first;
            } else if(pos == 1){
                rez[idx] = second;
            } else if(pos == 2){
                rez[idx] = third;
            } else {
                rez[idx] = String.valueOf(pos + 1);
            }
            pos++;
        }

        return rez;
    }
}
