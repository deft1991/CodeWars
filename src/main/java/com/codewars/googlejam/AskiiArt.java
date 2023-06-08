package com.codewars.googlejam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Sergey Golitsyn
 * created on 15.04.2023
 */
public class AskiiArt {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt(); // number of test cases
        for (int t = 1; t <= T; t++) {
            long N = input.nextLong(); // N-th character to find
            if (N < 26) {
                System.out.printf("Case #%d: %c\n", t, (char) ('A' + N - 1));
            } else {
                char c = findNthChar(N);
                System.out.printf("Case #%d: %c\n", t, c);
            }
        }
        input.close();
    }

    // find the N-th character in Cody-Jamal's program
    private static char findNthChar(long N) {
        Map<Integer, Character> map = new HashMap<>();
        String alp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] chars1 = alp.toCharArray();
        int charPos = 0;
        int lettercount = 1;
        for (int i = 0; i < N; ) {
            for (int j = 0; j < chars1.length; j++) {
                for (int x = 0; x < lettercount; x ++){
                    map.put(i++, chars1[j]);
                }
            }
            lettercount++;
        }

        return map.get((int)N - 1);
    }
}
