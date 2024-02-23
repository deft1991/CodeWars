package com.codewars.leetcode.daily;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Sergey Golitsyn
 * created on 16.02.2024
 */
public class LeastNumberUniqueIntegersafterKRemovals {

    public static void main(String[] args) {
        LeastNumberUniqueIntegersafterKRemovals l = new LeastNumberUniqueIntegersafterKRemovals();
//        System.out.println(l.findLeastNumOfUniqueInts(new int[]{5,5,4}, 1));
//        System.out.println(l.findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2}, 3));
        System.out.println(l.findLeastNumOfUniqueInts(new int[]{2,4,1,8,3,5,1,3}, 3));
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : arr){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        SortedSet<Pair> set = new TreeSet<>((a,b) -> {
            if (Integer.compare(a.count, b.count) == 0){
                return Integer.compare(a.value, b.value);
            }
            return Integer.compare(a.count, b.count);
        });
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            set.add(new Pair(entry.getValue(), entry.getKey()));
        }
        for(Pair p : set){
            int count = p.count;
            while(k > 0 && count > 0){
                k--;
                count--;
            }
            if (count == 0){
                map.remove(p.value);
            }
        }
        return map.size();
    }

    record Pair(int count, int value){}
}
