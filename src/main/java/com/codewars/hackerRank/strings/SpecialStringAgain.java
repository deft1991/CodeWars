package com.codewars.hackerRank.strings;

import java.util.Scanner;

/*
 * Created by sgolitsyn on 10/20/19
 *
 * https://www.hackerrank.com/challenges/special-palindrome-again/problem
 */
public class SpecialStringAgain {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        int substrCount = n;

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int plusCount = 1;
            char current = chars[i];


            int sameCharsLength = 1;
            while (plusCount + i < chars.length) {
                char next = chars[i + plusCount];

                if (current == next) {
                    substrCount++;
                    plusCount++;
                    sameCharsLength++;
                    continue;
                } else {
                    int anagramLength = sameCharsLength * 2 + 1 + i;
                    if (anagramLength > s.length()) {
                        anagramLength = s.length();
                    }
                    boolean isAnagram = isAnagram(s.substring(i, anagramLength));
                    if (isAnagram) {
                        substrCount++;
                        break;
                    }
                }
                break;
            }
        }
        return substrCount;
    }

    private static boolean isAnagram(String substr) {
        char[] chars = substr.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }

        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);
        System.out.println(result);
        scanner.close();
    }
}

