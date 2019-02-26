package com.codewars.hackerRank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Golitsyn Sergey (sgolitsyn)
 * @since 2/26/2019
 */
public class SockMerchant {

  // Complete the sockMerchant function below.
  private static int sockMerchant(int n, int[] ar) {
    Arrays.sort(ar);
    int pairs = 0;
    Integer tmp;
    for (int i = 0; i < ar.length-1;) {
      tmp = ar[i];
      int poll = ar[i + 1];
      if (tmp.equals(poll)) {
        pairs++;
        i += 2;
      } else {
        i++;
      }
    }
    return pairs;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] ar = new int[n];

    String[] arItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arItem = Integer.parseInt(arItems[i]);
      ar[i] = arItem;
    }

    int result = sockMerchant(n, ar);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
