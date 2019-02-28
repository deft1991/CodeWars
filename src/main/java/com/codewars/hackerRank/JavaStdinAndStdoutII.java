package com.codewars.hackerRank;

import java.util.Scanner;

/**
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 2/28/2019
 */
public class JavaStdinAndStdoutII {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int i = scan.nextInt();
    double d = scan.nextDouble();
    scan.nextLine();
    String s = scan.nextLine();

    // Write your code here.

    System.out.println("String: " + s);
    System.out.println("Double: " + d);
    System.out.println("Int: " + i);
  }
}
