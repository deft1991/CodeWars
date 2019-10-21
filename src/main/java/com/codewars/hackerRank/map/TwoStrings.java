package com.codewars.hackerRank.map;

import java.io.IOException;
import java.util.Scanner;

/*
 * Created by sgolitsyn on 10/21/19
 *
 * https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps&h_r=next-challenge&h_v=zen
 */
public class TwoStrings {
    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        int[] arr = new int[28];
        for (char c : s1.toCharArray()) {
            arr[c - 'a'] += 1;
        }

        for (char c : s2.toCharArray()) {
            if (arr[c -'a'] != 0) {
                return "YES";
            }
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);
        }


        scanner.close();
    }
}
