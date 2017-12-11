package com.codewars.level7;

import java.util.Arrays;
import java.util.stream.Stream;

/*Given an array of numbers, determine whether the sum of all of the numbers is odd or even.
Give your answer in string format as 'odd' or 'even'.
If the input array is empty consider it as: [0] (array with a zero).
Example:
oddOrEven([2, 5, 34, 6]) returns "odd".
Have fun!*/
public class OddOrEven {
    public static String oddOrEven(int[] array) {
//        // your code
//        if (array == null || array.length == 0)
//            return "even";
//        int summ = 0;
//        for (int i : array) {
//            summ += i;
//        }
//        return summ % 2 == 0 ? "even" : "odd";
        return Arrays.stream(array).sum() % 2 == 0 ? "even" : "odd";
    }
}
