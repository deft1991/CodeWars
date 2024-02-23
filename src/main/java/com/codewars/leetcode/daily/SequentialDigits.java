package com.codewars.leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 02.02.2024
 */
public class SequentialDigits {

    public static void main(String[] args) {
        SequentialDigits s = new SequentialDigits();
//        System.out.println(Arrays.toString(s.sequentialDigits(100, 300).toArray()));
        System.out.println(Arrays.toString(s.sequentialDigits(1000, 13000).toArray()));
//        System.out.println(Arrays.toString(s.sequentialDigits(10, 100).toArray()));
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> rez = new ArrayList<>();

        for (int i = 1; i <= 9; i++ ){
            int num = i;
            int nextDigit = i+1;

            while(num <= high && nextDigit <= 9){
                num = num * 10 + nextDigit;

                if(low <= num && num <= high){
                    rez.add(num);
                }
                nextDigit++;
            }
        }
        Collections.sort(rez);
        return rez;
    }
}
