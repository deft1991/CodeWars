package com.codewars.hackerRank.strings;

import java.io.IOException;
import java.util.Scanner;

/*
 * Created by sgolitsyn on 10/20/19
 *
 * https://www.hackerrank.com/challenges/common-child/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 * helpfull tips:
 * https://www.geeksforgeeks.org/printing-longest-common-subsequence/
 * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 */
public class CommonChild {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        int[][] arr = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }
        return arr[s1.length()][s2.length()];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);
        System.out.println(result);

        scanner.close();
    }
}

