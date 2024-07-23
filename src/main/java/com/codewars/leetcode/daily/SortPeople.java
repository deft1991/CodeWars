package com.codewars.leetcode.daily;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

/**
 * @author Sergey Golitsyn
 * created on 22.07.2024
 */
public class SortPeople {

    public static void main(String[] args) {

    }

    public String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b)-> Integer.compare(a.h, b.h));


        for(int i = 0; i < heights.length; i++){
            q.add(new Pair(heights[i], names[i]));
        }

        for(int i = 0; i < names.length; i++){
            names[i] = q.poll().s;
        }
        return names;
    }

    record Pair(int h, String s){}
}
