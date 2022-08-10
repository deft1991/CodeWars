package com.codewars.leetcode.explore.arrays;

/**
 * @author Sergey Golitsyn
 * created on 17.11.2021
 */
public class ThirdMaximumNumber {

    public static void main(String[] args) {

    }

    public int thirdMax(int[] arr) {
        Integer first = null;
        Integer second = null;
        Integer third = null;

        for (int i = 0; i < arr.length; i++) {
            if ((first != null && first == arr[i]) || (second != null && second == arr[i]) || (third != null && third == arr[i])) {
                continue;
            }


            if (first == null || arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            } else if (second == null || arr[i] > second){
                third = second;
                second = arr[i];
            } else if (third == null || arr[i] > third){
                third = arr[i];
            }
        }
        return third != null ? third : first;
    }
}
