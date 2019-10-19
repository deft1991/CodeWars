package com.codewars.hackerRank.strings;

import java.io.IOException;
import java.util.Scanner;

/*
 * Created by sgolitsyn on 10/20/19
 *
 * https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 */
public class MakingAnagrams {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {

        int[] chars = new int[128];

        char[] splitA = a.toCharArray();
        char[] splitB = b.toCharArray();

        for (char c : splitA) {
            chars[c]++;
        }

        for (char c : splitB) {
            chars[c]--;
        }

        int rez = 0;
        for (int count : chars) {
            int abs = Math.abs(count);
            if (0 != abs) {
                rez += abs;
            }
        }
        return rez;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        System.out.println(res);
        scanner.close();
    }
}
