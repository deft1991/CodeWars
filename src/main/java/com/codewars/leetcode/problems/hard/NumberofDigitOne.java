package com.codewars.leetcode.problems.hard;

/**
 * @author Sergey Golitsyn
 * created on 07.06.2021
 */
public class NumberofDigitOne {

    public static void main(String[] args) {
        NumberofDigitOne numberofDigitOne = new NumberofDigitOne();
//        System.out.println(numberofDigitOne.countDigitOne(13));
//        System.out.println(numberofDigitOne.countDigits(13, 1));
//        System.out.println(numberofDigitOne.countDigitOne(0));
//        System.out.println(numberofDigitOne.countDigits(0, 1));

        System.out.println(numberofDigitOne.countDigits(20, 1));
//        System.out.println(numberofDigitOne.countDigits(513, 2));
    }

    public int countDigitOne(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            count += getCount(i);
        }
        return count;
    }

    private int getCount(int i) {
        int count = 0;

        while (i > 0) {
            if (i % 10 == 1) {
                count++;
            }
            i /= 10;
        }
        return count;
    }

    public int countDigits(int value, int targetDigit) {
        // base case
        if (value == 0) {
            return 0;
        }
        int power = 1;

        while (power * 10 < value) {
            power *= 10;
        }

        int first = value / power;
        int remainder = value % power;

        int nTargetDigitFirst = 0;

        if (first > targetDigit) {
            nTargetDigitFirst = power;
        } else if (first == targetDigit) {
            nTargetDigitFirst = remainder + 1;
        }

        return first * countDigits(power - 1, targetDigit) + countDigits(remainder, targetDigit) + nTargetDigitFirst;
    }
}
