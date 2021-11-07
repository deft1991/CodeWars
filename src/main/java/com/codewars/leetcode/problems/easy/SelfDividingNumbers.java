package com.codewars.leetcode.problems.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author Sergey Golitsyn
 * created on 19.05.2021
 */
public class SelfDividingNumbers {

    public static void main(String[] args) {
        SelfDividingNumbers s = new SelfDividingNumbers();
        System.out.println(Arrays.toString(s.selfDividingNumbers(1,22).toArray()));
        Queue<Integer> arr = new ArrayDeque<>();
    }

    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> selfDivided = new ArrayList<>();

        for(int i = left; i <= right; i++){
            int num = i;
            while(num > 0){
                int digit = num % 10;
                if(digit == 0){
                    break;
                }
                if (i % digit != 0){
                    break;
                }
                num = num / 10;
            }
            if (num == 0){
                selfDivided.add(i);
            }
        }
        return selfDivided;
    }
}
