package com.codewars.hackerRank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 2/26/2019
 */
public class CountingValleys {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    //    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    String s = scanner.nextLine();
    int result = countingValleys(n, s);

    writer.write(String.valueOf(result));
    writer.newLine();
    writer.close();
    scanner.close();
  }

  // Complete the countingValleys function below.
  static int countingValleys(int n, String s) {
    int count = 0;

    return count;
  }
}
