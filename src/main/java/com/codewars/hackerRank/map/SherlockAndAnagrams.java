package com.codewars.hackerRank.map;

import java.io.IOException;
import java.util.Scanner;

/*
 * Created by sgolitsyn on 10/21/19
 *
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 */
public class SherlockAndAnagrams {
    static int sherlockAndAnagrams(String s) {
        int count = 0;
        int[] charsCount = new int[28];

        char[] chars = s.toCharArray();

        for (char c : s.toCharArray()) {
            charsCount[c - 'a']++;
        }

        return 0;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            System.out.println(result);

        }


        scanner.close();
    }
}

