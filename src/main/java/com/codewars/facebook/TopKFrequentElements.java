package com.codewars.facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Sergey Golitsyn
 * created on 28.08.2023
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        TopKFrequentElements t = new TopKFrequentElements();
        System.out.println(Arrays.toString(t.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(k, (a, b) -> Integer.compare(b.getValue(), a.getValue()));

        pq.addAll(map.entrySet());
        int[]rez = new int[k];
        for(int i = 0; i < k; i++){
            rez[i] = pq.poll().getKey();
        }
        return rez;
    }
}
