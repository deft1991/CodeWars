package com.codewars.hackerRank.strings;

import java.io.IOException;
import java.util.Scanner;

/*
 * Created by sgolitsyn on 10/20/19
 *
 * https://www.hackerrank.com/challenges/alternating-characters/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings&h_r=next-challenge&h_v=zen
 */
public class AlternatingCharacters {
    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {

        int delCount = 0;

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length - 1;) {
            int j = i + 1;
            while (j < chars.length && chars[i] == chars[j]) {
                delCount++;
                j++;
            }
            i = j;

        }
        return delCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);
            System.out.println(result);
        }


        scanner.close();
    }
}
