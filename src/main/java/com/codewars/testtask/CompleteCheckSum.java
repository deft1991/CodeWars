package com.codewars.testtask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 25.10.2023
 */
public class CompleteCheckSum {

    public static void main(String[] args) {
        Arrays.toString(completeCheckSum(List.of(3,44,55,66,2,110,220)).toArray());
    }

    public static List<Integer> completeCheckSum(List<Integer> fileBytes){
        List<Integer> rez = new ArrayList<>();
        int pointer = 0;

        while (pointer < fileBytes.size()){
            int endIdx = pointer + fileBytes.get(pointer);
            int sum = 0;
            pointer++;
            while (pointer <= endIdx){
                sum += fileBytes.get(pointer);
                pointer++;
            }
            rez.add(sum % 256);
        }
        return rez;
    }


}

