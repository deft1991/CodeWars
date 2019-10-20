package com.codewars.hackerRank.strings;

import java.io.IOException;
import java.util.Scanner;

/*
 * Created by sgolitsyn on 10/20/19
 *
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 */
public class SherlockAndTheValidString {
    // Complete the isValid function below.
    static String isValid(String s) {
        int[] chars = new int[28];
        for (char stringChar : s.toCharArray()) {
            chars[stringChar - 'a']++;
        }

        int charCount = chars[0];

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                chars[i] -= charCount;
            }
        }

        boolean isOne = false;
        for (int aChar : chars) {
            if (Math.abs(aChar) > 0) {
                if (isOne) {
                    return "NO";
                }
                isOne = true;
            }
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        String result = isValid(s);
        System.out.println(result);
        scanner.close();
    }
}
