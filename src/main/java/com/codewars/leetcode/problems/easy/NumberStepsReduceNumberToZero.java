package com.codewars.leetcode.problems.easy;

/**
 * @author Sergey Golitsyn
 * created on 28.03.2021
 */
public class NumberStepsReduceNumberToZero {

    public static void main(String[] args) {
        NumberStepsReduceNumberToZero n = new NumberStepsReduceNumberToZero();

        System.out.println(n.numberOfSteps(14)); // 6
        System.out.println(n.numberOfSteps(8)); // 4
        System.out.println(n.numberOfSteps(123)); // 12
    }

    public int numberOfSteps (int num) {
        int rez = 0;

        if (num == 0){
            return rez;
        }

        while (num != 0){
            if (num % 2 == 0){
              num /= 2;
            } else {
                num -= 1;
            }
            rez ++;
        }
        return rez;
    }
}
