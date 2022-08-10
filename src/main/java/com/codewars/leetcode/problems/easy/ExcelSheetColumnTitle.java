package com.codewars.leetcode.problems.easy;

import java.util.Arrays;

/**
 * @author Sergey Golitsyn
 * created on 26.07.2022
 */
public class ExcelSheetColumnTitle {

    public static void main(String[] args) {
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(701));
        int[] sChars = new int[256];
        Arrays.fill(sChars, -1);
    }

    public static String convertToTitle(int columnNumber) {
        if (columnNumber <= 26) {
           return String.valueOf ((char)((columnNumber + 'A') - 1));
        }
        StringBuilder sb = new StringBuilder();

        int overTimes = columnNumber;

        while(overTimes > 0){
            int rest =   overTimes % 26;
            if (rest == 0) {
                sb.append('Z');
                overTimes = overTimes / 26 - 1;
            } else {
                sb.append(((char)((rest + 'A') - 1)));
                overTimes /= 26;
            }
        }

        return sb.reverse().toString();
    }
}
