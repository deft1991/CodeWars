package com.codewars.pramp;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 24.01.2023
 */
public class AwardBudgetCuts {

    public static void main(String[] args) {
        AwardBudgetCuts a = new AwardBudgetCuts();

        System.out.println(a.findGrantsCap(new double[]{2, 100, 50, 120, 1000}, 190)); // 47
        System.out.println(a.findGrantsCap(new double[]{14,15,16,17,18,19}, 97)); // 17
        System.out.println(a.findGrantsCap(new double[]{14,15,16,17,18,19}, 98)); // 18
        System.out.println(a.findGrantsCap(new double[]{14,15,16,17,18,19}, 99)); // 19
    }

    static double findGrantsCap(double[] arr, double newBudget) {
        // your code goes here
        Arrays.sort(arr); // O(N*LogN)
        int n = arr.length-1;
        double cap = newBudget/n+1;
        for(int i = 0; i < n; i++) { // O(N)
            if(arr[i] < cap) {
                newBudget -= arr[i];
                cap = (newBudget/(n-i));
            }else {
                arr[i] = cap;
            }
        }

        return cap;
    }
}
