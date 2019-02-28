package com.codewars.hackerRank;

import java.util.Scanner;

/**
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 2/28/2019
 */
public class JavaLoopsI {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int N = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    scanner.close();
    for (int i = 0; i < 10;) {
      ++i;
      System.out.printf("%d x %d = %d%n", N, i, N * i);
    }
  }
}
