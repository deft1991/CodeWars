package com.codewars.leetcode.daily;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 16.01.2024
 */
public class InsertDeleteGetRandom {

    public static void main(String[] args) {

    }


}

class RandomizedSet {

    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int idx = map.get(val);
        int lastIdx = list.size()-1;
        if(idx != lastIdx){
            int lastVal = list.get(lastIdx);
            list.set(idx, lastVal);
            map.put(lastVal, idx);
        }
        list.remove(lastIdx);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
