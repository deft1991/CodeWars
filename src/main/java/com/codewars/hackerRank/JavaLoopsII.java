package com.codewars.hackerRank;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 2/28/2019
 */
public class JavaLoopsII {

  public static void main(String[] argh) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    int a, b, n;
    for (int i = 0; i < t; i++) {
      a = in.nextInt();
      b = in.nextInt();
      n = in.nextInt();

      String collect = getInts(a, b, n);
      System.out.println(collect);
    }
    in.close();
  }

  private static String getInts(int a, int b, int n) {
    int[] ints = new int[n];
    for (int j = 0; j < n; j++) {
      double rez = a + rec(b, j);
      ints[j] = (int) rez;
    }
    return Arrays.stream(ints).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  private static double rec(int b, int n) {
    if (n == 0) {
      return b;
    } else {

      return b * Math.pow(2, n) + rec(b, n - 1);
    }
  }
}
