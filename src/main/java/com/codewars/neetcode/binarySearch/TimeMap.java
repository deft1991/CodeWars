package com.codewars.neetcode.binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 03.01.2023
 */
public class TimeMap {

    public static void main(String[] args) {
        TimeMap t = new TimeMap();
        t.set("foo", "bar", 1);
        System.out.println(t.get("foo", 1)); // bar
        System.out.println(t.get("foo", 3)); // bar
        t.set("foo", "bar2", 4);
        System.out.println(t.get("foo", 4)); // bar2
        System.out.println(t.get("foo", 5)); // bar2
    }

    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            List<Pair> list = new ArrayList<>();
            list.add(new Pair(value, timestamp));
            map.put(key, list);
        } else {
            map.get(key).add(new Pair(value, timestamp));
        }
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Pair> pairs = map.get(key);
        int start = 0;
        int end = pairs.size() - 1;
        String rez = "";

        while (start <= end) {
            int mid = start + (end - start) / 2;
            Pair pair = pairs.get(mid);
            if (pair.timestamp == timestamp) {
                return pair.value;
            }
            if (pair.timestamp < timestamp) {
                rez = pair.value;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return rez;
    }

    static class Pair {
        String value;
        int timestamp;

        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }

    }
}
