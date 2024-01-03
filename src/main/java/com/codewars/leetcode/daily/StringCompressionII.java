package com.codewars.leetcode.daily;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Sergey Golitsyn
 * created on 28.12.2023
 */
public class StringCompressionII {

    public static void main(String[] args) {
        StringCompressionII s = new StringCompressionII();
//        System.out.println(s.getLengthOfOptimalCompression("aaabcccd", 2)); // 4
        System.out.println(s.getLengthOfOptimalCompression("aabbaa", 2)); // 2
//        System.out.println(s.getLengthOfOptimalCompression("aaaaaaaaaaa", 0)); //3
    }

    public int getLengthOfOptimalCompression(String s, int k) {

        StringBuilder sb = new StringBuilder();
        int count = 1;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                count++;
            } else {
                if (count == 1 && k > 0) {
                    k--;
                } else if (count / 10 == 1 || count / 100 == 1) {
                    k--;
                    sb.append(s.charAt(i - 1));
                    sb.append(count - 1);
                    map.put(count - 1, map.getOrDefault(count - 1, 0) + 1);
                    set.add(count - 1);
                    set.add(count - 1);
                } else if (count > 0) {
                    sb.append(s.charAt(i - 1));
                    sb.append(count);
                    map.put(count, map.getOrDefault(count, 0) + 1);
                    set.add(count);
                }

                count = 1;
            }
        }
        if (count == 1 && k > 0) {
            k--;
        } else if (k > 0 && (count / 10 == 1 || count / 100 == 1)) {
            sb.append(s.charAt((s.length() - 1) - 1));
            sb.append(count - 1);
            map.put(count - 1, map.getOrDefault(count - 1, 0) + 1);
            set.add(count - 1);
        } else if (count > 0) {
            sb.append(s.charAt(s.length() - 1));
            sb.append(count);
            map.put(count, map.getOrDefault(count, 0) + 1);
            set.add(count);
        }
        int rez = sb.length();
        for(int i : set) {
            if (k < i){
                break;
            }
            if (k > 0){
                map.put(i, map.get(i) - 1);
                if (map.get(i) == 0) {
                    map.remove(i);
                }
                k-=i;

                rez -= 1;
                rez -= String.valueOf(i).length();
            }

        }
        return rez;

    }
}
