package com.codewars.leetcode.mock;

/**
 * @author Sergey Golitsyn
 * created on 22.01.2024
 */
public class KthMissingPositiveNumber {

    public static void main(String[] args) {
        KthMissingPositiveNumber k = new KthMissingPositiveNumber();
        System.out.println(k.findKthPositive(new int[]{2,3,4,7,11}, 5));
    }

    public int findKthPositive(int[] arr, int k) {
        int counter = 1;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] != counter){
                k--;
                i--;
            }
            if(k == 0){
                return counter;
            }
            counter++;
        }

        return arr[arr.length-1] + k;
    }
}
