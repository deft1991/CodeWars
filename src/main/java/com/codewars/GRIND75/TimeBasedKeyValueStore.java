package com.codewars.GRIND75;

import java.util.*;

/**
 * @author Sergey Golitsyn
 * created on 21.09.2023
 */
public class TimeBasedKeyValueStore {


    public static void main(String[] args) {
        TimeMap tm = new TimeMap();
        tm.set("a", "bar", 1);
        tm.set("x", "b", 3);
        System.out.println(tm.get("b", 3));
        tm.set("foo", "bar2", 4);
        System.out.println(tm.get("foo", 4));
        System.out.println(tm.get("foo", 5));
    }
}

class TimeMap {
    class Node {
        String val;
        int timestamp;

        Node(String val, int timestamp){
            this.val = val;
            this.timestamp = timestamp;
        }
    }

    private Map<String, List<Node>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            List<Node> set = new ArrayList<>();
            map.put(key, set);
        }
        map.get(key).add(new Node(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<Node> nodes = map.get(key);

        return binarySearch(nodes, timestamp);
    }

    private String binarySearch(List<Node> list, int target) {
        int start = 0;
        int end = list.size()-1;
        Node rez = null;
        while(start <= end){
            int mid = start + (end - start) / 2;
            Node midNode = list.get(mid);
            if(list.get(mid).timestamp == target){
                return midNode.val;
            }
            if(midNode.timestamp < target){
                start = mid + 1;
                rez = midNode;
            } else {
                end = mid - 1;
            }
        }
        return rez == null ? "" : rez.val;
    }
}
