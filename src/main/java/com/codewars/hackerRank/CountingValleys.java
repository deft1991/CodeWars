package com.codewars.hackerRank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 2/26/2019
 */
public class CountingValleys {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String UP = "U";
    private static final String DOWN = "D";

    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("OUTPUT_PATH.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();
        int result = countingValleys(n, s);

        writer.write(String.valueOf(result));
        writer.newLine();
        writer.close();
        scanner.close();
    }

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        AtomicInteger count = new AtomicInteger();
        AtomicInteger valleys = new AtomicInteger();
        AtomicBoolean underSea = new AtomicBoolean(true);

        String[] strings = s.split("");
        IntStream.range(0, n).forEach(ind -> {
            String step = strings[ind];

            if (UP.equals(step)) {
                count.getAndIncrement();
            } else if (DOWN.equals(step)) {
                count.getAndDecrement();
            }
            if (count.get() < 0) {
                underSea.set(false);
            }
            if (0 == count.get() && !underSea.get()) {
                    valleys.getAndIncrement();
                    underSea.set(true);
            }

        });

        return valleys.get();
    }
}
