package com.codewars.neetcode.arraysAndHashing;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sergey Golitsyn
 * created on 04.12.2022
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        TopKFrequentElements t = new TopKFrequentElements();
        int[] ints = t.topKFrequent(new int[]{1, 1, 1, 2, 2}, 1);
        System.out.println(Arrays.toString(ints));

        int[] ints1 = t.topKFrequent(new int[]{1, 1, 1, 2, 2}, 2);
        System.out.println(Arrays.toString(ints1));

        int[] ints2 = t.topKFrequent(new int[]{3, 1, 1, 1, 2, 2}, 2);
        System.out.println(Arrays.toString(ints2));

        int[] ints3 = t.topKFrequent(new int[]{3, 1, 1, 1, 2, 2}, 3);
        System.out.println(Arrays.toString(ints3));
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] rez = new int[k];
        Map<Integer, Integer> map= new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                pq.add(entry);
                if (pq.size() > k){
                    pq.poll();
                }
        }
        int i = k;
        while(!pq.isEmpty()){
            rez[--i] = pq.poll().getKey();

        }
        return rez;
    }

    public int[] topKFrequent2(int[] nums, int k) {

        Map<Integer, Integer> map= new HashMap<>();

        for(int n : nums){
            if (map.containsKey(n)){
                map.put(n, map.get(n)+ 1);
            } else {
                map.put(n, 1);
            }
        }

        System.out.println();

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

        return list.stream().limit(k).map(Map.Entry::getKey).mapToInt(i -> i).toArray();
    }
}
