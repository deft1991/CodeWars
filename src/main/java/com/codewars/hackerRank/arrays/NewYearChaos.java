package com.codewars.hackerRank.arrays;

/*
 * Created by sgolitsyn on 10/18/19
 */

import java.util.Scanner;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribesMin(int[] q) {
        int countReArrangement = 0;
        for (int i = 0; i < q.length; i++) {
            int cur = q[i];
            if (cur > i + 1) {
                if (cur > i + 3) {
                    System.out.println("Too chaotic");
                    return;
                } else {
                    while (q[i] != i + 1) {
                        int nextPerson = q[i] - 1;
                        int tmp = q[nextPerson];
                        if (tmp - 1 > nextPerson + 2) {
                            System.out.println("Too chaotic");
                            return;
                        } else {
                            q[q[i] - 1] = q[i];
                            q[i] = tmp;
                            countReArrangement++;
                        }
                    }

                }
            }
        }
        System.out.println(countReArrangement);
    }

    // Complete the minimumBribes function below.
    // 1 2 5 3 7 8 6 4

    /**
     * passed all tests
     * смотреть на того кто подкупил твое место на 1, и исколь тех кто больше тебя до твоей позиции
     * @param q
     */
    static void minimumBribes(int[] q) {
        int countReArrangement = 0;

        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] - i > 3) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
                if (q[j] > q[i])
                    countReArrangement++;
            }
        }
        System.out.println(Math.abs(countReArrangement));
    }

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * test input
     * 2
     * 5
     * 2 1 5 3 4
     * 5
     * 2 5 1 3 4
     * or
     * 1
     * 5
     * 2 1 5 3 4
     *
     * @param args
     */
    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}

