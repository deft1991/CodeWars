package com.codewars.leetcode.daily;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 15.12.2023
 */
public class DestinationCity {

    public static void main(String[] args) {

    }

    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();

        for (List<String> list : paths) {
            String a = list.get(0);
            set.add(a);

        }
        for (List<String> list : paths) {
            String b = list.get(1);
            if (!set.contains(b)) {
                return b;
            }

        }
        return "";
    }
}
