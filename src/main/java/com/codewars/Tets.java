package com.codewars;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by sgolitsyn on 5/7/20
 */
public class Tets {


    public static void main(String[] args) {
        new Tets().getPrimesCount(10);
    }

    public int getPrimesCount(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        int count = 1;
        for (int i = 2; i < n; i++) {
            if (map.get(i) == null) {
                count++;
                map.put(i, i);
                int tmp = i;
                while (tmp < n) {
                    tmp += i;
                    map.put(tmp, i);
                }
            }
        }

        System.out.println(count);
        return count;
    }
}
